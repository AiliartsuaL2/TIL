package item04;

public class UtilityClass {
    public static String hello(){ // 정적 메서드만 제공하는 클래스
        return "hello";
    }

    public static void main(String[] args) {
       // UtilityClass utilityClass = new UtilityClass(); // 1. 인스턴스를 생성이 됨,
       // utilityClass.hello(); // 인스턴스를 통해 접근함, 굉장히 불필요한 코드

        String hello = UtilityClass.hello();// 원래의 목적,,
        System.out.println(hello);
    }

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    // 4. 주석을 통해 문서화시 API문서에 알리기
    private UtilityClass(){ // 2.private한 생성자를 만들어서 외부에서 인스턴스화를 막고,
        throw new AssertionError(); // 3.내부에서 인스턴스를 만들어도 사용 못하도록 에러를 만듬/
    }

}
