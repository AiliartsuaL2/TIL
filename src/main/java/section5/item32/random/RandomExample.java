package section5.item32.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();
        // Random에서 내부적으로 next() 메서드 하나만 이용
        // AtomicLong을 사용 -> 낙관적 락 사용 (CompareAndSet(Swap))
        // 이미 안전하게 구현이 되어있지만, 실패하여 재시도를 하는 경우가 생길 수 있음 -> 성능 저하
        System.out.println(random.nextInt(10));

        // 현재 스레드에 할당되어있는 랜덤값을 가져옴.
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(10));
    }

    private int value;

    // 낙관적 락은 compareAndSet() 메서드로 구현되어있는데 네이티브로 구현되어있어 확인이 불가능하다.
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int readValue = value;
        if (readValue == expectedValue) {
            value = newValue;
        }
        return readValue;
    }
}
