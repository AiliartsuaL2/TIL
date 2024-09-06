package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        // 데몬으로 설정
        daemonThread.setDaemon(true);
        // 시작 후 데몬의 실행 완료를 기다리지 않음
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000); // 10초간 스레드 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
