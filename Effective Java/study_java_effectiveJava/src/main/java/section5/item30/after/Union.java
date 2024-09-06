package section5.item30.after;

import java.util.HashSet;
import java.util.Set;

public class Union {
    // 제네릭 타입은 접근 지시자와 return 타입 사이에 정의
    // 제네릭으로 정의시 버그를 컴파일 타임에 잡을 수 있음
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "주호", "해리");

//        Set<Integer> stooges = Set.of(1, 2, 3);
        Set<String> stooges = Set.of("1", "2", "3");
        Set<String> all = union(guys, stooges);

        for (String s : all) {
            System.out.println(s);
        }
    }
}
