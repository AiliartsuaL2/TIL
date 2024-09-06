package section5.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {
    public static void main(String[] args) {
        // 공변
        Object[] anything = new String[10];
        anything[0] = 1;
        // Object로 받으며 타입이 변할 수 있음
        // -> 위와 같이 문제가 될 수 있으나 컴파일러가 잡지 못함

        // 불공변
        List<String> names = new ArrayList<>();

        // 이렇게 되지 않음
        // List<Object> objects = names;


        // 제네릭과 배열을 같이 사용 할 수 있다면 . . 아래와 같은 문제 발생
//        List<String>[] strings = new ArrayList<String>[1];
//        List<Integer> ints = List.of(42);
//        Object[] objects = strings;
//        objects[0] = ints;
        // string으로 강제 형변환 시도 -> ClassCastException 발생
//        String s = strings[0].get(0);
//        System.out.println(s);
    }
}
