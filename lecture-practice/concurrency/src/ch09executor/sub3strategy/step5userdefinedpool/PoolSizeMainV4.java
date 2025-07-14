package ch09executor.sub3strategy.step5userdefinedpool;


import ch09executor.RunnableTask;

import java.util.concurrent.*;

import static util.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV4 {

    // 상황 바꿔가며 실행
    //static final int TASK_SIZE = 1100; // 1. 일반적인 상황
    //static final int TASK_SIZE = 1200; // 2. 긴급 상황
    static final int TASK_SIZE = 1202; // 3. 거절  (1201 로 설정하면, 로컬 pc에서 의도한 예외발생이 안돼서 1202 로 설정)

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(
                100,
                200,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000));

        printState(es);

        long startMs = System.currentTimeMillis();
        for (int i = 1; i < TASK_SIZE; i++) {
            String taskName = "task" + i;

            try {
                es.execute(new RunnableTask(taskName));
                printState(es, taskName);
            } catch (RejectedExecutionException e) {
                log(taskName + "-> " + e);
            }
        }

        es.close();
        long endMs = System.currentTimeMillis();
        log("time:" + (endMs - startMs));
    }
}

/* 소요시간은 보장x
1. 일반적인 상황 
    1000 개 이하의 작업이 큐에서 대기 -> 100개의 기본스레드가 처리
    [     main] time:11111

2. 긴급 상황 
    큐에 대기 중인 작업이 1000개 초과 -> 100개 기본 스레드 + 100개 초과 스레드가 처리

    [     main] time:7074
        초과스레드가 재사용되고있기때문에, 1번상황보다 더 빠름

3. 거절 상황
    초과 스레드 투입했으나,
    큐에 담긴 작업 1000개 초과, 초과 스레드도 넘어간 상황
    -> 총 1200개의 작업 초과시  RejectedExecutionException 발생
    [     main] time:6138
*/


/* 설정 주의사항

MaximumPoolSize를 설정해도,

블로킹 큐를
new LinkedBlockingQueue() 사용 시 무한대 사이즈로 사용
-> 큐가 가득 찰 수 없음
-> 초과 스레드 생성 불과 (MaximumPoolSize 설정한게 의미가 없어짐)

*/