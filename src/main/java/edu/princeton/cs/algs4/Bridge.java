package edu.princeton.cs.algs4;


/******************************************************************************
 *  Compilation:  javac Bridge.java
 *  Execution:    java  Bridge V E
 *  Dependencies: Graph.java GraphGenerator.java
 *
 *  Identifies bridge edges and prints them out. This decomposes
 *  a directed graph into two-edge connected components.
 *  Runs in O(E + V) time.
 *
 *  Key quantity:  low[v] = minimum DFS preorder number of v
 *  and the set of vertices w for which there is a back edge (x, w)
 *  with x a descendant of v and w an ancestor of v.
 *
 *  Note: code assumes no parallel edges, e.g., two parallel edges
 *  would be (incorrectly) identified as bridges.
 *
 ******************************************************************************/

public class Bridge {
    private int bridges;      // number of bridges
    private int cnt;          // counter
    private int[] ord;        // ord[v] = order in which dfs examines v
    private int[] low;        // low[v] = lowest preorder of any vertex connected to v

    public Bridge(Graph G) {
        low = new int[G.V()];
        ord = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            low[v] = -1;
        for (int v = 0; v < G.V(); v++)
            ord[v] = -1;

        for (int v = 0; v < G.V(); v++)
            if (ord[v] == -1)
                dfs(G, v, v);
    }

    public int components() { return bridges + 1; }

    private void dfs(Graph G, int p, int v) {
        //previsit
        ord[v] = cnt++;
        //init low as ord
        low[v] = ord[v];
        StdOut.println("pre visit " + v +" ord is " + ord[v] +" low is "+ low[v]);
        for (int c : G.adj(v)) {
            if (ord[c] == -1) {//not visit yet
                dfs(G, v, c);
                //postvisit
                //visit done, update low as min of its children
//                StdOut.println("post visit " + v +" ord is " + ord[v] +" low is "+ low[v]);
                //maybe children have been relaxed in inner dfs, so parent also need to relax again.
                low[v] = Math.min(low[v], low[c]);
                if (low[c] == ord[c]) {
                    StdOut.println(v + "-" + c + " is a bridge");
                    bridges++;
                }
            }

            // update low number - ignore reverse of edge leading to v
            // cycle found, relax parent
            else if (c != p) {
                StdOut.println("cycle found " + v +" -> " + c +" -> " + p);
                low[v] = Math.min(low[v], low[c]);
            }
        }
        StdOut.println("post visit " + v +" ord is " + ord[v] +" low is "+ low[v]);

    }

    // test client
    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0,1);
        G.addEdge(2,4);
        G.addEdge(2,0);
        G.addEdge(2,3);
        G.addEdge(1,4);
//        G.addEdge(4,5);
        StdOut.println(G);

        Bridge bridge = new Bridge(G);
        StdOut.println("Edge connected components = " + bridge.components());
    }


}

