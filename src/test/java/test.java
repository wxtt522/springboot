/**
 * Created by Administrator on 2017/10/19.
 */
public class test {

    public static void main(String[] args) {

        first f = new first();
        f.say();
        first.saystatic();
        f.saystatic();

        System.out.println(f.a);
        System.out.println(f.b);
        System.out.println(first.b);
    }
}
