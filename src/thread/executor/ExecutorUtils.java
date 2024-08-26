package thread.executor;

import static util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        // ThreadPoolExecutor로 캐스팅
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            // 현재 생성된 스레드의 개수가 몇개인지
            int pool = poolExecutor.getPoolSize();

            // 실제 작업을 하고있는 스레드의 개수가 몇개인지
            int active = poolExecutor.getActiveCount();

            // 작업이 몇개 들어가있는지
            int queuedTasks = poolExecutor.getQueue().size();

            // 작업이 완료된 스레드가 몇개인지
            long completedTaskCount = poolExecutor.getCompletedTaskCount();

            log("[pool=" + pool + ", active=" + active + ", queuedTasks=" + queuedTasks + ", completedTaskCount=" + completedTaskCount + "]");
        } else {
            log(executorService);
        }
    }
}
