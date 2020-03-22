/**
 * @author tailor
 * @create 2020/3/22 - 17:15
 * @mail wql2014302721@gmail.com
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;
    public ArrayQueue(){
        array = new Array<T>();
    }
    public ArrayQueue(int capacity){
        array = new Array<T>(capacity);
    }

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Queue: Front [");
        for(int i=0; i<array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize()-1){
                sb.append(",");
            }
        }
        sb.append("] Tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for(int i=0;i<6; i++){
            queue.enqueue(i);
            System.out.println(queue);
        }
        for(int i=0; i<6; i++){
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
