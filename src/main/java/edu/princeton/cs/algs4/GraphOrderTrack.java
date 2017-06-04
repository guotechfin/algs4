package edu.princeton.cs.algs4;

public class GraphOrderTrack {
    private int[] preorder;
    private int[] postorder;
    private boolean[] visited;
    private int clock;
    public GraphOrderTrack(Graph G){
        preorder = new int[G.V()];
        postorder = new int[G.V()];
        visited = new boolean[G.V()];
        clock = 0;
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(G, v);
    }

    private void dfs(Graph G, int v){
        preorder[v] = clock++;
        StdOut.println("previsit "+ v + " at clock "+ preorder[v]);
        visited[v] = true;
        for (int c : G.adj(v)){
            if(!visited[c]){
                dfs(G,c);
            }
        }
        postorder[v] = clock++;
        StdOut.println("postvisit "+ v + " at clock "+ postorder[v]);
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0,1);
        G.addEdge(2,4);
        G.addEdge(2,0);
        G.addEdge(2,3);
        G.addEdge(1,4);
        StdOut.println(G);

        GraphOrderTrack track = new GraphOrderTrack(G);
    }
}
