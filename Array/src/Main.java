import org.omg.Messaging.SyncScopeHelper;

import javax.xml.ws.soap.AddressingFeature;
import java.util.Objects;

/**
 * @author tailor
 * @create 2020/3/22 - 9:47
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
//        Array arr = new Array(20);
//        for(int i=0; i<10; i++){
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//        arr.add(2, 100);
//        System.out.println(arr);
//        arr.addFirst(-1);
//        System.out.println(arr);
//        arr.remove(2);
//        System.out.println(arr);
//        arr.removeElement(100);
//        System.out.println(arr);

        User u1 = new User("zhangsan", 12);
        User u2 = new User("lisi", 23);
        User u3 = new User("wangwu", 42);
        User u4 = new User("zhaoliu", 36);
        Array<User> array = new Array<>();
        array.addLast(u1);
        array.addLast(u2);
        array.addLast(u3);
        array.addLast(u4);
        System.out.println(array);
        int index = array.findIndex(new User("lisi", 23));
        System.out.println(index);
        array.remove(1);
        System.out.println(array);
    }
}

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

}