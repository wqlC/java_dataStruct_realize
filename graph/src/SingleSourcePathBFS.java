import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class SingleSourcePathBFS {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] pre;
    public SingleSourcePathBFS(Graph G, int s){
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            pre[i] = -1;
        }
        bfs(s, s);
    }

    private void bfs(int s, int parent) {
        //TODO
    }
    private boolean isConnected(int t){
        return visited[t];
    }
    public Iterable<Integer> path(int t){
        ArrayList<Integer> res = new ArrayList<>();
        if(!isConnected(t)) return res;
        int cur = t;
        while(cur!=s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("./graph/g.txt");
        Iterable<Integer> path = new SingleSourcePathBFS(graph, 0).path(6);
        System.out.println(path);
    }
}
