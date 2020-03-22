
/**
 * @author tailor
 * @create 2020/3/22 - 17:32
 * @mail wql2014302721@gmail.com
 */
public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front;
    private int tail;
    private int size;

    /**
     * Constructor
     * @param capacity
     */
    public LoopQueue(int capacity){
        data = (T[])new Object[capacity+1];
        size = 0;
    }
    public LoopQueue(){
        this(10);
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(T t) {
        // 判断是否扩容
        if(size == getCapacity()){
            resize(2*getCapacity());
        }
        data[tail] = t;
        tail = (tail+1)%data.length;
        size++;
    }
    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity+1];
        for(int i=0; i<size; i++){
            newData[i] = data[(front+i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not dequeue from an Empty queue.");
        }
        T ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if(size == getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not get element from an Empty queue.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("LoopQueue: size:%d, capacity:%d\n", size, getCapacity()));
        sb.append("front [");
        for(int i=front; i!=tail; i = (i+1)%data.length){
            sb.append(data[i]);
            if((i+1)%data.length != tail){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<Integer>();
        for(int i=0;i<10; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
