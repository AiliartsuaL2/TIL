package section5.item32;

import java.util.ArrayList;
import java.util.List;

// 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다. (191-192쪽)
public class Dangerous {
    // 코드 32-1 제네릭과 varargs를 혼용하면 타입 안전성이 깨진다! (191-192쪽)
    static void dangerous(List<String>... stringLists) {
//        배열은 공변, 제네릭은 불공변이기 때문에 제네릭 타입의 배열을 선언 할 수 없다
//        List<String>[] myList = new ArrayList<String>[100];
//        가변 인자는 내부적으로 배열로 관리되기 때문에 같이 사용은 되나
//        컴파일 에러가 아닌 컴파일 경고가 뜬다. ( 힙 오염으로 인해 굉장히 위험한 코드)
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
