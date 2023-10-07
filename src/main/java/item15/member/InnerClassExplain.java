package item15.member;

// private static으로 선언하는 이유
//  - private class로 선언하는경우, 이너 클래스가 해당 클래스를 감싸고있는 외부 인스턴스를 항상 참조를 한다. >> 내부 필드 등 접근이 수월하다.
//- private static class의 경우, inner class지만 아무런 참조가 생기지 않음 >> 완전 독립적인 class가 된다.

public class InnerClassExplain {
    private String name;

    private static class PrivateStaticClass{
        void doPrint(){
            // InnerClassExplain와 아예 관계 없는 class,, 인스턴스를 내부 클래스가 갖지 않기 때문에 접근이 불가능.
//            System.out.println(name);
        }
    }
    private class PrivateClass{
        // 상위의 InnerClassExplain의 인스턴스를 내부 클래스가 가지고 있기 때문에 접근이 가능
        void doPrint(){
            System.out.println(name);
        }

    }


}
