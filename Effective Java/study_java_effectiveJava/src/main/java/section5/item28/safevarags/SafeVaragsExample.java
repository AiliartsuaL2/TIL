package section5.item28.safevarags;

import java.util.List;

public class SafeVaragsExample {
    // 가변인자에는 제네릭 배열 같이 사용 가능
    // 이렇게되면 전달받은 배열이 오염(내부 데이터에 들어가면 안되는 데이터가 들어감) 될 수 있다.
    //
    static void notSafe(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = List.of(42);
        array[0] = tmpList;
        String s = stringLists[0].get(0);
    }

    @SafeVarargs
    // 오염이 될 가능성이 없는 로직에서는 해당 애노테이션을 선언해주면 Warning 없어짐
    static <T> void safe(T...values) {
        for (T value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        SafeVaragsExample.safe("a","b","c");
        SafeVaragsExample.notSafe(List.of("a","b","c"));
    }
}
