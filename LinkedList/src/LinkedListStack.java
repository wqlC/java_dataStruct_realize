/**
 * @author tailor
 * @create 2020/3/23 - 11:37
 * @mail wql2014302721@gmail.com
 */
public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: Top ");
        sb.append(list);
        return  sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();
        for(int i=0; i<5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.push(100);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
