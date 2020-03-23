/**
 * @author tailor
 * @create 2020/3/23 - 13:30
 * @mail wql2014302721@gmail.com
 */
public class LinkedListQueue<E> implements Queue<E> {
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
        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head, tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public void enqueue(E e) {
        if(null == tail){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        Node node = head;
        head = head.next;
        size--;
        return node.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedListQueue: size:%d [head ", size));
        Node cur = head;
        while(cur != null){
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("NULL tail]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for(int i=0;i<10; i++){
            queue.enqueue(i);
            if(i%3 == 2){
                queue.dequeue();
            }
            System.out.println(queue);
        }
    }
}
