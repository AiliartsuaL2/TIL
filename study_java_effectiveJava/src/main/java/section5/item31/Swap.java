package section5.item31;

import java.util.*;

// 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드 (189쪽)
public class Swap {
    // 메서드 시그니쳐가 간단해지지만, 넣는것 (Produce)이 불가능해진다.
    // -> 굳이 필요하지 않다고 생각
    public static void swap(List<?> list, int i, int j) {
        // 참조 타입을 모르기 때문에 컴파일 에러
//        list.set(i, list.set(j, list.get(i)));
        swapHelper(list, i, j);
    }

    // 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        // 첫 번째와 마지막 인수를 스왑한 후 결과 리스트를 출력한다.
        List<String> argList = Arrays.asList(args);
        swap(argList, 0, argList.size() - 1);
        System.out.println(argList);
    }
}
