package section5.item32;

import java.util.ArrayList;
import java.util.List;

// 코드 32-3 제네릭 varargs 매개변수를 안전하게 사용하는 메서드 (195쪽)
public class FlattenWithVarargs {
//    @SuppressWarnings("unchecked")
// SuppressWarnings 애노테이션으로 컴파일 경고를 제거 할 수 있지만
    // @SafeVarargs 를 사용하면, 가변인자에 대한 컴파일 경고를 제거 할 수 있음 (더 구체적 -> 유지보수 용이)
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7));
        System.out.println(flatList);
    }
}
