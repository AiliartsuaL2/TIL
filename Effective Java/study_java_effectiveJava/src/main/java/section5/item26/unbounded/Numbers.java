package section5.item26.unbounded;

import java.util.Set;

public class Numbers {
    static int numElementsInCommon(Set s1, Set<?> s2) {
        // 이런식으로 선언이 되어있지 않으면 체크를 못함
//        s1.add("ailiartsua");

        // ?로 선언이 되어있으면 null을 제외하고서는 아무것도 넣을 수 없음
//        s2.add("ailiartsua");
        int result = 0;
        for (Object o1 : s1) {
            if(s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result : "+Numbers.numElementsInCommon(Set.of(1, 2, 3), Set.of(1, 2)));
        System.out.println("result : "+Numbers.numElementsInCommon(Set.of(1, 2, 3), Set.of("1", 2)));
    }
}
