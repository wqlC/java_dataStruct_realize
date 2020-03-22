/**
 * @author tailor
 * @create 2020/3/22 - 16:23
 * @mail wql2014302721@gmail.com
 */
public interface Stack<T> {
    int getSize();
    boolean isEmpty();
    T pop();
    T peek();
    void push(T t);

}
