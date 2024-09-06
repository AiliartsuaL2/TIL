package section5.item26.terms;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {
    public static void main(String[] args) {
        /** 로 타입 예제
        // Generic을 사용하지 않고 Raw Type으로 선언
        List numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add("ailiartsua");

        for (Object number : numbers) {
            System.out.println((Integer)number);
        }
        // Object로 받기 때문에 Compile 타임에 에러를 잡을 수 없다.
         */

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        // 제네릭을 사용하면 컴파일 타임에 에러를 찾을 수 있다.
//        numbers.add("ailiartsua");

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
