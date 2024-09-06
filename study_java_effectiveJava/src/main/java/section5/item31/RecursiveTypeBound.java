package section5.item31;

import java.util.*;
import section5.item31.example.PresentBox;

// 와일드카드 타입을 사용해 재귀적 타입 한정을 다듬었다. (187쪽)
public class RecursiveTypeBound {
    // Comparable은 소비자이기 때문에 super
    public static <E extends Comparable<? super E>> E max(
            List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("빈 리스트");

        E result = null;
        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = e;

        return result;
    }

    public static void main(String[] args) {
        List<PresentBox> list = new ArrayList<>();
        list.add(new PresentBox(1, "ailiartsua"));
        list.add(new PresentBox(2, "이주호"));

        System.out.println(max(list));
    }
}
