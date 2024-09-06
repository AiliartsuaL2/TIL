package section5.item27.suppress;

import java.util.Arrays;

public class ListExample {
    private int size;
    Object[] elements;


    public <T> T[] toArray(T[] a) {
        // 컴파일러는 타입 안정성을 보장되는지 모르지만, 실질적으로 안전성이 보장되는경우 애너테이션 사용
        if (a.length < size) {
            // 경고를 무시해주는 애노테이션
            // 주석으로 설명을 충분히 써주자.
            // return 문에서는 붙일 수 없으니까, 변수로 받거나 메서드 상위에 붙이면됨.
            // best practice -> 가능한 한 좁은 범위에 붙이는 것 (아래와 같이) + 주석으로 설명
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());

            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
