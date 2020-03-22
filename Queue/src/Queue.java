/**
 * @author tailor
 * @create 2020/3/22 - 17:13
 * @mail wql2014302721@gmail.com
 */
public interface Queue<T> {
    void enqueue(T t);
    T dequeue();
    T getFront();
    int getSize();
    boolean isEmpty();
}
