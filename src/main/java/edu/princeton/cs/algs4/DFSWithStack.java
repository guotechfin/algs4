package edu.princeton.cs.algs4;


import java.util.Iterator;

public class DFSWithStack {
    private boolean[] marked;
    public DFSWithStack(Graph G, int s){
        marked = new boolean[G.V()];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        marked[s] = true;

        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++)
            adj[v] = G.adj(v).iterator();

        while(!stack.isEmpty()){
            int t = stack.peek();
            if(adj[t].hasNext()){
                int w = adj[t].next();
                if(!marked[w]){
                    marked[w] = true;
                    stack.push(w);
                }
            }else{
                StdOut.println(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(5);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(1,3);
        G.addEdge(3,4);
//        G.addEdge(0,1);
        DFSWithStack finder = new DFSWithStack(G,0);

    }

}
