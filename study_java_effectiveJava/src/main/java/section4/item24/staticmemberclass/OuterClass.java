package section4.item24.staticmemberclass;

public class OuterClass {
    private static int number = 10;

    /**
     * 정적 멤버 클래스
     * 장점
     *  - 바깥쪽의 static한 변수에 접근 가능,
     *  - 바깥 클래스의 인스턴스를 필요로 하지 않는다.
     * 적합한 사용처
     *  - 단독으로 사용하지 않고, Outer 클래스와 함께 사용 할 때 유용한 것을 정의 할 때 사용
     */
    private static class InnerClass {
        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }
}
