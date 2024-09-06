package section5.item26.object;

import java.util.ArrayList;
import java.util.List;

// 런타임 도중에 실패 -> unsafeAdd 메서드가 로 타입(List)을 사용하고 있기 떄문에
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        // 넣을때에는 에러가 나지 않고, 꺼낼 때 난다.
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어줌

        // List<Object>로 매개변수를 받으면, List<String>과는 다른 타입이기 때문에 안됨.
//        safeAdd(strings, Integer.valueOf(42));

    }

    // 타입 안정성을 잃은 코드0
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }

    private static void moreSafeAdd(List<String> list, String o) {
        list.add(o);
    }
}
