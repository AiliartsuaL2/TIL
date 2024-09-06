package section4.item21.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {
    public static void main(String[] args) {
        // of로 만든 Collection은 수정 불가능 (이뮤터블) 컬렉션
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(4);
        numbers2.add(5);

        // for-each문은 내부적으로 fail-fast 이터레이터로 콜렉션을 순회함.
        // remove를 사용하면 ConcurrentModificationException 발생
//        for (Integer integer : numbers2) {
//            numbers2.remove(integer);
//        }

        // 1. 이터레이터를 직접 사용하며 iterator가 직접 자기 자신에 remove 사용 -> 안전
        for (Iterator<Integer> iterator = numbers2.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            if(integer == 3) {
                iterator.remove();
            }
        }
        
        // 2. 인덱스를 사용
        for (int i = 0; i < numbers2.size(); i++) {
            if (numbers2.get(i) == 3) {
                numbers2.remove(numbers2.get(i));
            }
        }

        // 3. removeIf 사용 -> 내부적으로 1번처럼 구현
        numbers2.removeIf(number -> number == 3);
        numbers2.forEach(System.out::println);
    }
}
