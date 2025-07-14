package ch09executor.sub3strategy.step2threadpoolsize;

import ch09executor.RunnableTask;

import java.util.concurrent.*;

import static util.ExecutorUtils.*;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/* ThreadPoolExecutor 속성 종류
- int corePoolSize
    스레드 풀에서 관리되는 기본 스레드의 수
- int maximumPoolSize
    스레드 풀에서 관리되는 최대 스레드 수 (초과 스레드)

- long keepAliveTime
- TimeUnit unit
    기본 스레드 수를 초과해서 만들어진 스레드가 생존할 수 있는 대기 시간
    이 시간동안 처리할 작업이 없다면 초과 스레드는 제거

- BlockingQueue<Runnable> workQueue)
    작업을 보관할 블로킹 큐
*/
public class PoolSizeMainV1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

        ExecutorService es = new ThreadPoolExecutor(
                2,
                4,
                3000,
                TimeUnit.MILLISECONDS,
                workQueue);
        printState(es); //[     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 0]

        es.execute(new RunnableTask("task1")); // 스레드 1개 생성
        printState(es,"task1"); //[     main] task1 -> [pool= 1, active= 1, queuedTasks= 0, completedTask= 0]

        es.execute(new RunnableTask("task2")); // 스레드 1개 생성
        printState(es,"task2"); //[     main] task1 -> [pool= 2, active= 2, queuedTasks= 0, completedTask= 0]

        es.execute(new RunnableTask("task3")); // core 사이즈만큼 스레드 생성상태, 현재 사용가능한 스레드 x -> 큐에 보관
        printState(es,"task3"); //[     main] task3 -> [pool= 2, active= 2, queuedTasks= 1, completedTask= 0]

        es.execute(new RunnableTask("task4")); // core 사이즈만큼 스레드 생성상태, 현재 사용가능한 스레드 x -> 큐에 보관
        printState(es,"task4"); //[     main] task4 -> [pool= 2, active= 2, queuedTasks= 2, completedTask= 0]


        // 기본스레드들은 모두 작업중 & 큐가 가득참 -> 초과 스레드 생성 -> 이때 들어온 작업을 바로 수행시작 (큐에 있던 작업보다 먼저)
        es.execute(new RunnableTask("task5"));
        printState(es,"task5"); //[     main] task5 -> [pool= 3, active= 3, queuedTasks= 2, completedTask= 0]

        es.execute(new RunnableTask("task6"));
        printState(es,"task6"); //[     main] task6 -> [pool= 4, active= 4, queuedTasks= 2, completedTask= 0]

        try {
            // 모든 스레드 작업중 & 큐 가득참 & 이미 스레드 수가 맥시멈 사이즈
            es.execute(new RunnableTask("task7"));

        } catch (RejectedExecutionException e) {
            log("task7 실행 거절 예외 발생: " + e);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es); //[     main] [pool= 4, active= 0, queuedTasks= 0, completedTask= 6]

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es); //[     main] [pool= 2, active= 0, queuedTasks= 0, completedTask= 6]
        // 기본사이즈를 초과한 후 생성된 스레드들은 지정시간동안 일이 없으면 삭제

        es.close();
        log("== shutdown 완료 ==");
        printState(es);
    }
}
/* 순서보장 x

    28.142 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 0]
    28.144 [     main] task1 -> [pool= 1, active= 1, queuedTasks= 0, completedTask= 0]
    28.144 [     main] task2 -> [pool= 2, active= 2, queuedTasks= 0, completedTask= 0]
    28.144 [     main] task3 -> [pool= 2, active= 2, queuedTasks= 1, completedTask= 0]
    28.144 [     main] task4 -> [pool= 2, active= 2, queuedTasks= 2, completedTask= 0]
    28.144 [pool-1-thread-2] task2시작
    28.144 [pool-1-thread-1] task1시작
    28.144 [     main] task5 -> [pool= 3, active= 3, queuedTasks= 2, completedTask= 0]
    28.144 [pool-1-thread-3] task5시작
    28.145 [     main] task6 -> [pool= 4, active= 4, queuedTasks= 2, completedTask= 0]
    28.145 [pool-1-thread-4] task6시작


    28.145 [     main] task7 실행 거절 예외 발생: java.util.concurrent.RejectedExecutionException: Task ch09executor.RunnableTask@3d646c37 rejected from java.util.concurrent.ThreadPoolExecutor@12edcd21[Running, pool size = 4, active threads = 4, queued tasks = 2, completed tasks = 0]
    29.152 [pool-1-thread-4] task6완료
    29.152 [pool-1-thread-4] task3시작
    29.152 [pool-1-thread-3] task5완료
    29.153 [pool-1-thread-3] task4시작
    29.152 [pool-1-thread-1] task1완료
    29.152 [pool-1-thread-2] task2완료
    30.154 [pool-1-thread-4] task3완료
    30.168 [pool-1-thread-3] task4완료
    31.159 [     main] == 작업 수행 완료 ==
    31.159 [     main] [pool= 4, active= 0, queuedTasks= 0, completedTask= 6]
    34.174 [     main] == maximumPoolSize 대기 시간 초과 ==
    34.174 [     main] [pool= 2, active= 0, queuedTasks= 0, completedTask= 6]
    34.175 [     main] == shutdown 완료 ==
    34.175 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 6]
    
    
Executor 스레드 풀 관리
1. 작업 요청 -> core 사이즈 만큼 스레드 생성
2. core 사이즈 초과 -> 작업은 큐에서 대기
3. 큐 사이즈 초과 
    -> 새로운 작업 요청
    -> max 사이즈 만큼 초과 스레드 생성 -> 바로 수행 (대기 작업 x, 새로운 작업)
4. max 사이즈 초과 시 요청 거절 -> 예외 발생
    (스레드 생성가능 수, 큐가 가득 찼을 경우)
*/