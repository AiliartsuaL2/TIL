package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {

        Thread threadA = new Thread(new PrintWork("A", 1000), "Thread-A");
        Thread threadB = new Thread(new PrintWork("B", 500), "Thread-B");

        threadA.start();
        threadB.start();
    }

    private static class PrintWork implements Runnable {

        private final String message;
        private final Integer sleepMs;

        public PrintWork(String message, Integer sleepMs) {
            this.message = message;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while(true) {
                log(this.message);
                try {
                    Thread.sleep(this.sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
