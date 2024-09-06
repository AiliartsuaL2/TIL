package thread.start.test;

import static util.MyLogger.log;

public class StartTest2Main {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        // 생성자로 이름 지정도 가능
        Thread thread = new Thread(myRunnable, "counter");
//        thread.setName("counter");
        thread.start();
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
