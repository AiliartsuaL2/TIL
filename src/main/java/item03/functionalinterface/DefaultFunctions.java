package item03.functionalinterface;

import item03.methodrefernce.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {
    public static void main(String[] args) {
        Function<Integer,String> intToString = (i) -> "hello"; // 인풋 Int, 아웃풋 String 형태의 함수의 타입
        Supplier<Integer> integerSupplier; // 받는게 없고 나오는것만 있음 (인자가 없고 리턴만 있는) 리턴 타입은 Integer

        Supplier<Person> personSupplier = Person::new; // 인자가 없는 기본 생성자 사용
        Function<LocalDate,Person> personFunction = Person::new; // 인자가 LocalDate인 생성자

        Consumer<Integer> integerConsumer; // void 메서드, 인자는 있고 리턴이 없는
        Predicate<Integer> predicate; // 인자를 제네릭으로 받아서 boolean을 리턴하는
    }
}
