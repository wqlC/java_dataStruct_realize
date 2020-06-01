public class CycleDetectionBFS {
    private Graph G;
    private boolean[] visited;
    private boolean hasCycle;
    public CycleDetectionBFS(Graph G){
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!visited[v]){
                bfs(v, v);
            }
        }
    }

    private void bfs(int v, int parent) {
        visited[v] = true;
        
    }


}
