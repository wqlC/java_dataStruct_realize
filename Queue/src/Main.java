import java.util.Random;

/**
 * @author tailor
 * @create 2020/3/22 - 18:34
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: " + time1+ "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time: " + time2+ "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LoopQueue time: " + time3+ "s");
    }

    public static double testQueue(Queue<Integer> queue, int opCount){
        double time1 = System.nanoTime();
        Random random = new Random();
        for(int i=0; i<opCount; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0; i<opCount; i++){
            queue.dequeue();
        }

        double time2 = System.nanoTime();
        return (time2-time1)/1000000000.0;
    }
}
