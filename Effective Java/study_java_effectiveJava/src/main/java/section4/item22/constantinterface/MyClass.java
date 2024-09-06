package section4.item22.constantinterface;

import section4.item22.constantutilitclass.PhysicalConstantsUtil;

public class MyClass implements PhysicalConstants{
    public static void main(String[] args) {
        // 인터페이스로 구현하면 내부 클래스에서 선언한 것 처럼 사용 가능해지는데,
        // 이러면 안된다 (안티패턴) >> 인터페이스의 원래 의도를 오염 시키기 때문 + 외부에서 내부 구현을 참조 할 수 있게 되기 때문
        // MyClass가 PhysicalConstantsUtil 타입이 되기위해 구현한것인가?를 생각해야함
        System.out.println(BOLTZMANN_CONSTANT);

        // 외부에서는 이렇게 사용해야하는지 의심하게됨
//        PhysicalConstantsUtil myClass = new MyClass();

        // 공통화 할 꺼면 인터페이스에 쓰지말고, 유틸리티 클래스를 만들어서 사용
        System.out.println(PhysicalConstantsUtil.BOLTZMANN_CONSTANT);
    }
}
