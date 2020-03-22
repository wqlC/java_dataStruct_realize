import java.util.Arrays;

/**
 * @author tailor
 * @create 2020/3/22 - 10:03
 * @mail wql2014302721@gmail.com
 */
public class Array<T> {
    private T[] data;
    private int size;

    /**
     * 构造方法
     * @param capacity
     */
    public Array(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法
     */
    public Array(){
        this(10);
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize() {
        return size;
    }
    /**
     * 获取数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组最后面添加元素
     * @param e
     */
    public void addLast(T e){
        add(size, e);
    }

    /**
     * 在数组最前面添加元素
     * @param e
     */
    public void addFirst(T e){
        add(0, e);
    }

    /**
     * 在 index 位置处添加元素 e
     * @param index
     * @param e
     */
    public void add(int index, T e){
        if(size == data.length){
            // throw new IllegalArgumentException("Add failed. Array is full.");
            resize(size*2);
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size.");
        }
        for(int i=size-1; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取数组index位置处的元素
     * @param index
     * @return
     */
    public T get(int index){
        if(index < 0 || index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改 index 位置处的元素
     * @param index
     * @param e
     */
    public void set(int index, T e){
        if(index < 0 || index>=size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含某一个元素
     * @param e
     * @return
     */
    public boolean contains(T e){
        for(int i=0; i<size; i++){
            if(e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中某一个元素对应的索引
     * @param e
     * @return
     */
    public int findIndex(T e){
        for(int i=0; i<size; i++){
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中index位置的元素, 返回删除的元素
     * @param index
     */
    public T remove(int index){
        if(index < 0 || index>=size){
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        T res = data[index];
        for(int i=index; i<size-1; i++){
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && 0 != data.length/2){
            resize(data.length/2);
        }
        return res;
    }
    public T removeFirst(){
        return remove(0);
    }
    public T removeLast(){
        return remove(size-1);
    }
    public void removeElement(T e){
        int index = findIndex(e);
        if(-1 != index){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Array: Size=%d, capacity=%d\n", this.size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if(i==size-1){
                sb.append(data[i]);
            }else{
                sb.append(data[i]+",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        T[] newData =(T[]) new Object[newCapacity];
        for(int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
