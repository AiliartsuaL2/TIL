package section5.item30.before;

import java.util.function.Function;

public class GenericSingletonFactory {
    // 타입이 다르기 때문에 같은 로직임에도 두개의 인스턴스를 생성
    public static Function<String, String> stringIdentifyFunction() {
        return (t) -> t;
    }

    public static Function<Number, Number> integerIdentifyFunction() {
        return (t) -> t;
    }

    public static void main(String[] args) {
        String[] strings = { "삼배", "대마", "나일론" };
        Function<String, String> sameString = stringIdentifyFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = { 1, 2.0, 3L };
        Function<Number, Number> sameNumber = integerIdentifyFunction();
        for (Number number : numbers) {
            System.out.println(sameNumber.apply(number));
        }
    }

}
