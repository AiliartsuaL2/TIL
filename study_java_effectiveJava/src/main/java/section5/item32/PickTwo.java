package section5.item32;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// 미묘한 힙 오염 발생 (193-194쪽)
public class PickTwo {
    // 코드 32-2 자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다! (193쪽)
    // 안전하게 사용을 하는 경우에는 괜찮으나,
    // 왠만하면 제네릭 타입의 가변인자로 받은 배열 자체를 return 시키지 말자.
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // 도달할 수 없다.
    }

    public static void main(String[] args) { // (194쪽)
        String[] attributes = pickTwo("좋은", "빠른", "저렴한");
        // 바이트 코드 내에서 Object -> 문자열로 캐스팅하는 코드가 작성된다. -> CCE 발생
        System.out.println(Arrays.toString(attributes));
    }
}
