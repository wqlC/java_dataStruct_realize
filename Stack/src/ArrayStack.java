/**
 * @author tailor
 * @create 2020/3/22 - 16:29
 * @mail wql2014302721@gmail.com
 */
public class ArrayStack<T> implements Stack<T> {

    private Array<T> array;

    public ArrayStack(){
        array = new Array<>();
    }
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Stack[");
        for(int i=0; i<array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize()-1){
                sb.append(",");
            }
        }
        sb.append("] Top");
        return sb.toString();
    }
}
