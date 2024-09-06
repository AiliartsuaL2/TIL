package section4.item24.anonymousclass;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // 익명 클래스, 정의 함과 동시에 구현한 인스턴스를 만듬
        // 람다 전에서 많이 사용되었으나, 8 이후로는 람다로 대체되었음
        return new AbstractList<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Integer get(int i) {
                return a[i];
            }
            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // 오토 언박싱
                return oldVal; // 오토 박싱
            }
        };
    }
}
