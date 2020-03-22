/**
 * @author tailor
 * @create 2020/3/22 - 16:37
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
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
