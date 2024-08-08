package thread.bounded;

import static util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        queue.add(data); // full이면 ISE 반환
    }

    @Override
    public String take() {
        return queue.remove(); // empty면 NSE 반환
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
