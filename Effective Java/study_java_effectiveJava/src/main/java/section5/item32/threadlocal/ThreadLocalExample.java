package section5.item32.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

    // 쓰레드 범위 내에서 선언된 변수 -> 쓰레드 로컬
    // SDF -> Thread - safe 하지 않음 (다른 스레드에 전파될 수 있음)
//    private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmm");

    // ThreadLocal로 감싸서 사용한다면, 멀티스레드 환경에서 다른 스레드에 영향을 주지 않음
    // 대표적으로 Spring에서 Transaction을 ThreadLocal로 관리
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10 ; i++) {
            Thread thread = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }
    @Override
    public void run() {
        System.out.println("Thread Name = " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name = " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }
}
