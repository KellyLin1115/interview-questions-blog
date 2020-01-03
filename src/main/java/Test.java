import java.util.Date;

public class Test {
    public static boolean f1(){
        System.out.println("invoke f1");
        return true;
    }

    public static boolean f2(){
        System.out.println("invoke f2");
        return false;
    }
    public static void main(String[] args) {
        System.out.println(f1() && f2());
        System.out.println(7&3);
    }
}