package section4.item24.memberclass;

public class OuterClass {
    private int number = 10;

    /**
     * 이런식으로 바깥 클래스의 인스턴스 메서드를 만들고,
     * InnerClass를 해당 메서드에서 생성해서 사용
     */
    void printNumber() {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }

    /**
     * 비 정적 중첩 클래스
     * - 암묵적으로 바깥 클래스의 인스턴스에대한 참조가 생긴다.
     *   - 감싸고있는 인스턴스 없이는 자기 자신을 생성 할 수 없다.
     * -> 비정적 중첩 클래스가 바깥쪽 클래스의 멤버를 참조하지 않고 있다면 static 클래스로 바꿔라
     */
    private class InnerClass {
        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.doSomething();
    }
}
