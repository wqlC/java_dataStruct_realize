import java.util.ArrayList;

/**
 * 图的深度优先搜索
 * @author tailor
 * @create 2020/5/6 - 16:04
 * @mail wql2014302721@gmail.com
 */
public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();
    public GraphDFS(Graph G){
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w: G.adj(v)){
            if(!visited[w]){
                dfs(w);
            }
        }
        post.add(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args){
        Graph graph = new Graph("D:\\CodeFiles\\javaCode\\java_datastruct\\graph\\g.txt");
        GraphDFS graphDFS = new GraphDFS(graph);
        System.out.println(graphDFS.pre());
        System.out.println(graphDFS.post());
    }
}
