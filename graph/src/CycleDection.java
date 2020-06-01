
/**
 * 检测图中是否有环
 */
public class CycleDection {
    private Graph G;
    private boolean[] visited;
    public boolean hasCycle;
    public CycleDection(Graph G){
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!visited[v]) {
                hasCycle = dfs(v, v);
                break;
            }
        }
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w: G.adj(v)){
            if(!visited[w]){
                if(dfs(w, v)){
                    return true;
                }
            }else if(w != parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Graph graph = new Graph("D:\\CodeFiles\\javaCode\\java_datastruct\\graph\\g.txt");
        System.out.println(new CycleDection(graph).hasCycle);
    }
}