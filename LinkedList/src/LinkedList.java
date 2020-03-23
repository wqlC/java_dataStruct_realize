import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * @author tailor
 * @create 2020/3/23 - 8:56
 * @mail wql2014302721@gmail.com
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e, null);
        }
        public Node (){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead; // 虚拟头节点
    private int size;
    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }
    /**
     * 获取链表长度
     * @return int 链表的大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return boolean 是否为空
     */
    public boolean isEmpty(){
        return 0==size;
    }


    /**
     * 在链表的index（0-based）位置添加新的元素 e
     * @param index 索引
     * @param e 要添加的元素
     */
    public void add(int index, E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for(int i=0; i<index; i++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
//            prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表的头部插入节点
     * @param e 传入的元素
     */
    public void addFirst(E e){
        add(0, e);
    }


    /**
     * 在链表的尾部添加元素
     * @param e 要添加的元素
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获取链表的第index（0-based）个位置的元素
     * @param index 索引
     * @return  对应位置的元素 e
     */
    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return  对应位置的元素e
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return  最后的元素e
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改链表的第index（0-based）个位置的元素为e
     * @param index  修改位置的索引
     * @param e 要改成啥元素
     */
    public void set(int index, E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Set Failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断 链表中是否包含元素e
     * @param e 要判断的元素
     * @return  是否包含元素e
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur!=null){
            if(e.equals(cur.e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表index（0-based）位置的元素
     * @param index 要删除的节点的索引
     * @return  返回删除的节点对应的元素
     */
    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove element failed. Illegal index");
        }
        Node cur = dummyHead;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        Node rmNode = cur.next;
        cur.next = cur.next.next;
        rmNode.next = null;
        size--;
        return rmNode.e;
    }

    /**
     * 删除链表的 第一个节点
     * @return 返回删除的节点对应的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("LinkedList[size:%d]\n", size));
        Node cur = dummyHead.next;
        while(cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
