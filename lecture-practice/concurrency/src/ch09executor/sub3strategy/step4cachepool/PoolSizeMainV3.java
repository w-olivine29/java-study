package ch09executor.sub3strategy.step4cachepool;


import ch09executor.RunnableTask;

import java.util.concurrent.*;

import static util.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV3 {
    public static void main(String[] args) {

        //ExecutorService es = Executors.newCachedThreadPool();
        //return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        //SynchronousQueue: 큐의 저장 공간이 0인 특별한 큐

            
        // 실습을 위해 직접 생존시간을 따로 설정
        ExecutorService es = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                3L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 4 ; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
    }
}

/* 순서 보장 x

    41.128 [     main] pool 생성
    41.138 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 0]
    41.145 [     main] task1 -> [pool= 1, active= 1, queuedTasks= 0, completedTask= 0]
    41.145 [     main] task2 -> [pool= 2, active= 2, queuedTasks= 0, completedTask= 0]
    41.145 [pool-1-thread-1] task1시작
    41.146 [     main] task3 -> [pool= 3, active= 3, queuedTasks= 0, completedTask= 0]
    41.145 [pool-1-thread-2] task2시작
    41.146 [pool-1-thread-3] task3시작
    41.146 [     main] task4 -> [pool= 4, active= 4, queuedTasks= 0, completedTask= 0]  작업이 추가될때마다 스레드가 계속 새로 생성되는 것을 볼 수 있음
    
    41.146 [pool-1-thread-4] task4시작
    42.160 [pool-1-thread-2] task2완료
    42.160 [pool-1-thread-1] task1완료
    42.160 [pool-1-thread-3] task3완료
    42.160 [pool-1-thread-4] task4완료

    44.161 [     main] == 작업 수행 완료 ==
    44.162 [     main] [pool= 4, active= 0, queuedTasks= 0, completedTask= 4]

    47.176 [     main] == maximumPoolSize 대기 시간 초과 ==
    47.176 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 4]
    47.176 [     main] == shutdown 완료 ==
    
    
 모든 작업이 대기하지 않고 작업의 수 만큼 스레드가 생성되면서 바로 실행
 초과 스레드는 지정한 대기 생존 시간이 지나고 모두 사라짐
*/

/* 캐시 풀 전략

- 매우 빠르고, 유연한 전략
- 기본 스레드가 없고, 대기 큐에 작업이 쌓이지도 않음
- 작업 요청 발생 시 -> 초과 스레드로 작업을 바로 처리 (빠른 처리 가능)
- CPU, 메모리 자원만 허용된다면 시스템의 자원을 최대로 사용 가능
- 초과 스레드들은 지정 대기 생존시간(60초) 동안 생존 -> 작업 수에 맞추어 적절한 수의 스레드 재사용
    -> 요청이 갑자기 증가하면 스레드 갑자기 증가
    -> 요청이 줄어들면 스레드도 점점 감소
    
    
단점이 될 수 있는 상황

상황1) 점진적인 사용자 확대
        사용자가 증가하면서 스레드 사용량도 증가 (CPU 메모리 사용량 증가) 하기때문에 문제를 빠르게 찾을 수 있음
        그러나
        CPU 메모리 자원은 한계가 있기때문에, 적절한 시점에 시스템 증설필요 (시스템 다운 위험)

상황2) 갑작스런 요청 증가 -> 사용자는 응답을 받지 못한다고 항의
        - CPU 메모리 사용량이 지나치게 높아져있는 상태
        - 너무많은 스레드가 작업을 처리하면서 시스템 전체가 느려지는 현상 발생
            - 수 천개의 스레드를 처리해야하니까 , 컨택스트 스위칭 비용도 증가
            
        - 수 천개의 스레드가 처리하는 속도보다 더 많은 작업이 들어옴 (재사용을 못하고 계속 새로 생성)
          -> 시스템은 너무 많은 스레드에 잠식 당해서 거의 다운, 메모리도 거의 다 사용한 상태
          -> 시스템이 멈추는 장애 발생


캐시 스레드 풀 전략은
서버의 자원을 최대한 사용하지만, 서버가 감당할 수 있는 임계점을 넘는 순간 시스템 다운
*/