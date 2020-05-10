import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author tailor
 * @create 2020/5/10 - 11:28
 * @mail wql2014302721@gmail.com
 */
public class SingleSourcePath {

    private boolean[] visited;
    private int[] pre;
    private Graph G;
    private int s;

    public SingleSourcePath(Graph G, int s){
        G.validateVertex(s);
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            pre[i] = -1;
        }
        dfs(s, s);
    }

    private void dfs(int v, int parent){
        visited[v] = true;
        pre[v] = parent;
        for (int w: G.adj(v)){
            if(!visited[w]){
                dfs(w, v);
            }
        }
    }
    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }
    public Iterable<Integer> path (int t){
        ArrayList<Integer> res = new ArrayList<>();
        if(!isConnectedTo(t)){
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
        SingleSourcePath ss = new SingleSourcePath(g, 0);
        System.out.println("0->6:"+ss.path(6));
        System.out.println("0->5:"+ss.path(5));
    }

}
