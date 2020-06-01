import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author tailor
 * @create 2020/5/6 - 15:41
 * @mail wql2014302721@gmail.com
 */
public class Graph {
    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    public Graph(String pathStr){
        File file = new File(pathStr);
        try(Scanner s = new Scanner(file)){
            V = s.nextInt();
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<Integer>();
            }
            E = s.nextInt();
            for (int i = 0; i < E; i++) {
                int a = s.nextInt();
                validateVertex(a);
                int b = s.nextInt();
                validateVertex(b);
                if(a==b){throw new IllegalArgumentException("自旋了");}
                if(adj[a].contains(b)) {throw new IllegalArgumentException("重复了");}
                adj[a].add(b);
                adj[b].add(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void validateVertex(int v){
        if(v<0 || v>=V){throw new IllegalArgumentException("点无效");}
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }
    public Iterable<Integer> adj(int v){// 返回顶点v连接的所有顶点
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d: ", v));
            for(int w : adj[v]){
                sb.append(String.format("%d ", w));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Graph graph = new Graph("D:\\CodeFiles\\javaCode\\java_datastruct\\graph\\g.txt");
        System.out.println(graph);
    }
}
