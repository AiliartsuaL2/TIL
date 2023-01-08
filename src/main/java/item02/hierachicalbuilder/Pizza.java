package item02.hierachicalbuilder;

import java.util.*;

// 코드 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴 (19쪽)

// 참고: 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> { // T에 하위타입으로 오게끔 해놨음
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) { // 하위타입을 리턴해줌, (하위타입을 리턴해야 하위타입 캐스팅 없이 메서드 체이닝을 할 수 있기 때문에)
            toppings.add(Objects.requireNonNull(topping));
            return self(); // 하위타입을 리턴해야하기 때문에 this가 아닌 self()를 해줬음
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding)하여
        // "this"를 반환하도록 해야 한다.
        protected abstract T self(); // 자바에는 셀프타입이 없기 때문에 우회를 해줘야함
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50 참조
    }
}