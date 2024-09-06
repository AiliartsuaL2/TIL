package section5.item30.before;

import java.util.HashSet;
import java.util.Set;

public class Union {
    // 로타입 메서드
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set guys = Set.of("톰", "주호", "해리");

        Set stooges = Set.of(1, 2, 3);
        // 합칠때까지는 문제가 생기지 않는다.
        Set all = union(guys, stooges);

        // 사용시 CCE 발생
        for (Object o : all) {
            System.out.println((String) o);
        }
    }
}
