import sun.nio.cs.FastCharsetProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的广度优先遍历
 */
public class GraphBFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphBFS(Graph G){
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!visited[v]){
                bfs(v);
            }
        }
    }

    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()){
            int temp = queue.remove();
            order.add(temp);
            for (int w : G.adj(temp)) {
                if(!visited[w]){
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }
    public Iterable<Integer> order(){
        return order;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("./graph/g.txt");
        GraphBFS gb = new GraphBFS(graph);
        System.out.println(gb.order());
    }
}
