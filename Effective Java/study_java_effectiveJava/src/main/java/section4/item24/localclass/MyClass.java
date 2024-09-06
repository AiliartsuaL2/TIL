package section4.item24.localclass;

public class MyClass {
    private int number = 10;

    /**
     * 지역 클래스
     * - 거의 안 씀
     * - 메서드 자체가 길어짐
     */
    void doSomething() {
        class LocalClass {
            private void printNumber() {
                System.out.println(number);
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printNumber();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.doSomething();
    }
}
