import java.util.function.DoubleConsumer;

/**
 * @author tailor
 * @create 2020/4/10 - 9:24
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer) a).hashCode());//42
        int b = -42;
        System.out.println(((Integer) b).hashCode());//-42
        double c = 3.145926;
        System.out.println(((Double) c).hashCode());// 2374754
        String d = "hello";
        System.out.println(d.hashCode());   // 99162322
    }
}
