/**
 * @author tailor
 * @create 2020/4/2 - 11:48
 * @mail wql2014302721@gmail.com
 */
public interface UF {
    int getSize();
    boolean idConnected(int p, int q);
    void UnionElements(int p, int q);
}
