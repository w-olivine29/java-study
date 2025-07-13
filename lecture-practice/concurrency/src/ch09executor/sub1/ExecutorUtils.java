package ch09executor.sub1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();

            // 내부에 생산자-소비자 구조로 돼있고, pool에 작업을 던지면 thread가 바로 실행하는게 아니라 queue에 작업이 담김
            int queuedTasks = poolExecutor.getQueue().size();

            // 작업을 완료한 스레드 개수
            long completedTask = poolExecutor.getCompletedTaskCount();

            log(String.format(
                    "[pool= %d, active= %d, queuedTasks= %d, completedTask= %d]",
                    pool, active, queuedTasks, completedTask
            ));
        }else {
            log(executorService);
        }
    }
}
