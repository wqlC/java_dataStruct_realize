
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class Path {

    private boolean[] visited;
    private int[] pre;
    private Graph G;
    private int s;
    private int t;


    public Path(Graph G, int s, int t){
        G.validateVertex(s);
        G.validateVertex(t);
        this.G = G;
        this.s = s;
        this.t = t;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {// pre 用于存储每一个顶点的前一个节点
            pre[i] = -1;
        }
        dfs(s, s);
    }

    private boolean dfs(int v, int parent){// parent 是v的前一个节点
        visited[v] = true;
        pre[v] = parent;
        if(v == t){
            return true;
        }
        for (int w: G.adj(v)){
            if(!visited[w]){
                if(dfs(w, v))
                    return true;
            }
        }
        return false;
    }
    public boolean isConnected(){
        return visited[t];
    }
    public Iterable<Integer> path (){
        ArrayList<Integer> res = new ArrayList<>();
        if(!isConnected()){
            return res;
        }
        int cur = t;
        while (cur != this.s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph("D:\\CodeFiles\\javaCode\\java_datastruct\\graph\\g.txt");
        Path path = new Path(g, 0, 6);
        System.out.println("0->6:"+path.path());
        path = new Path(g, 0, 1);
        System.out.println("0->1:"+path.path());
        path = new Path(g, 0, 5);
        System.out.println("0->5:"+path.path());


    }

}
