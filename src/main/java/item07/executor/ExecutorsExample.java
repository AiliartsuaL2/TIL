package item07.executor;

import java.util.concurrent.*;

public class ExecutorsExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfCpu = Runtime.getRuntime().availableProcessors();
        System.out.println("numberOfCpu = " + numberOfCpu);
//        ExecutorService service = Executors.newFixedThreadPool(numberOfCpu);
        // newCachedThreadPool >> 자동으로 thread를 할당하는데, 이것도 thread를 생성해서 사용,, 무한정 생성 할 수 있음,, 그래서 조심해야함
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(numberOfCpu);

//        Thread thread = new Thread(new Task());
//        thread.start();
//        for (int i = 0; i < 100; i++) {
//            service.submit(new Task());
//        }
        Future<String> submit = service.submit(new Task2());

        System.out.println(Thread.currentThread() + "hello");

        // get을 하는 순간 Blocking이 들어감
        System.out.println(submit.get());
        service.shutdown();
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            try{
                Thread.sleep(2000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "world");
        }
    }

    static class Task2 implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }
}
