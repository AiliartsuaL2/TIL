package item13.exception;

public class MyApp {
    public static void hello(){
        System.out.println("hello world");
        throw new MyException();
    }

    public static void main(String[] args) {
        hello();
    }
}
