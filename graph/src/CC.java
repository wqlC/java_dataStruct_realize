import java.util.ArrayList;
import java.util.List;

/**
 * 求无向图的连通分量
 */
public class CC {
    private Graph G;
    private int[] visited;
    private int cccount=0;
    public CC(Graph G){
        this.G = G;
        visited = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            visited[v] = -1;
        }
        for (int v = 0; v < G.V(); v++) {
            if(visited[v] == -1) {
                dfs(v, cccount);
                cccount++;
            }
        }
    }

    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (int w: G.adj(v)){
            if(visited[w] == -1){
                dfs(w, ccid);
            }
        }
    }

    public int count(){
        for (int v = 0; v < G.V(); v++) {
            System.out.print(visited[v]+" ");
        }
        System.out.println();
        return cccount;
    }

    public boolean isConnected(int v, int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v]==visited[w];
    }

    public List<Integer>[] components(){
        List<Integer>[] res = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++) {
            res[i] = new ArrayList<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }

    public static void main(String[] args){
        Graph graph = new Graph("D:\\CodeFiles\\javaCode\\java_datastruct\\graph\\g.txt");
        CC cc = new CC(graph);
        System.out.println(cc.count());
        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(0, 5));

        List<Integer>[] comp = cc.components();
        for (int ccid = 0; ccid < comp.length; ccid++) {
            System.out.print(ccid + ": ");
            for(int w: comp[ccid]){
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
