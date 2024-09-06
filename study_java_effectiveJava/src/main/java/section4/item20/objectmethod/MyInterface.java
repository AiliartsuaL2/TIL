package section4.item20.objectmethod;

// 인터페이스에서 디폴트 메서드로 Object 메서드 재정의를 하려는 경우
// 애초에 컴파일 에러가 난다.
// 이유
//  - 복잡도가 증가된다 ( 실제 메서드를 어떤 메서드를 사용해야하는지, (Object에서 제공하는, Interface에서 Default Method로 재정의한 메서드인지..)
//     - 근본적인 룰은 interface 보다 클래스가 더 우선순위가 높지만, 해당 인터페이스의 구현체는 Object를 결국 상속하기 때문에 근본적인 룰이 깨짐.
//  - 디폴트 메서드와 목적이 인터페이스의 진화이지, 위험을 가져다주기 위한 용도가 아니다.
public interface MyInterface {
//    default String toString() {
//        return "myString";
//    }
//    default int hashCode() {
//        return 10;
//    }
//    default boolean equals(Object o) {
//        return true;
//    }
}
