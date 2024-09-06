package section2.item01.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 질문 1. 내림차순으로 정렬하는 Comparator을 만들고 List<Integer>을 정렬하라.
 * 질문 2. 만든 Comparator을 갖고 오름차순으로 정렬하라
 */
public class ComparatorQuiz {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(50);
        list.add(36);
        list.add(87);
        list.add(107);

//        Comparator<Integer> desc = new Comparator<Integer>() { // 내림차순 Comparator
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        } ;

        Comparator<Integer> desc = (o1, o2) -> o2-o1; // 람다로 변환

        Collections.sort(list, desc.reversed());// 다시 오름차순으로 변경,, 기본 제공 메서드

        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
    }
}
