import sun.awt.image.ImageWatched;

/**
 * @author tailor
 * @create 2020/3/23 - 9:38
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0; i<5; i++){
            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
