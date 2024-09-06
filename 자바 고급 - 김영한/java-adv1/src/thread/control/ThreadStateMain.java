package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState()); // 실행 전 -> NEW
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // 스레드가 sleep -> TIMED WAITING
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); // 스레드 종료 -> TERMINATED
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = "+ Thread.currentThread().getState()); // 스레드가 실행 중 -> RUNNABLE
                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.state4 = "+ Thread.currentThread().getState()); // 스레드가 잠에서 깸 -> RUNNABLE
                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
