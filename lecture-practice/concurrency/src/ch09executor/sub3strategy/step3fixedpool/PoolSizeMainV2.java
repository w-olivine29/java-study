package ch09executor.sub3strategy.step3fixedpool;


import ch09executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV2 {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(2);
        //return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 6 ; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        es.close();
        log("== shutdown 완료 ==");
    }
}

/*
    34.318 [     main] pool 생성
    34.328 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 0]
    34.334 [     main] task1 -> [pool= 1, active= 1, queuedTasks= 0, completedTask= 0]
    34.334 [     main] task2 -> [pool= 2, active= 2, queuedTasks= 0, completedTask= 0]
    34.335 [     main] task3 -> [pool= 2, active= 2, queuedTasks= 1, completedTask= 0]
    34.335 [     main] task4 -> [pool= 2, active= 2, queuedTasks= 2, completedTask= 0]
    34.335 [pool-1-thread-2] task2시작
    34.335 [pool-1-thread-1] task1시작
    34.335 [     main] task5 -> [pool= 2, active= 2, queuedTasks= 3, completedTask= 0]
    34.336 [     main] task6 -> [pool= 2, active= 2, queuedTasks= 4, completedTask= 0]
    35.338 [pool-1-thread-2] task2완료
    35.338 [pool-1-thread-1] task1완료
    35.338 [pool-1-thread-2] task3시작
    35.338 [pool-1-thread-1] task4시작
    36.355 [pool-1-thread-2] task3완료
    36.355 [pool-1-thread-1] task4완료
    36.355 [pool-1-thread-2] task5시작
    36.356 [pool-1-thread-1] task6시작
    37.362 [pool-1-thread-1] task6완료
    37.362 [pool-1-thread-2] task5완료
    37.362 [     main] == shutdown 완료 ==
*/

/* 고정 풀 전략

newFixedThreadPool(nThreads)
    - 스레드 풀에 nThreads 만큼의 기본 스레드 생성 (초과 스레드 생성x)
    - 큐 사이즈 제한 x (LinkedBlockingQueue)
    - 스레드 수가 고정되어있기 때문에 
        CPU, 메모리 자원이 어느정도 예측 가능한 안정적인 방식
        
단점이 될 수 있는 상황
 상황1) 점진적인 사용자 확대
        고정 스레드 전략을 사용해서 서비스를 안정적으로 운영했었으나,
        점점 사용자가 늘어가면서 사용자들이 서비스 응답이 느려진다고 항의
 
 상황2) 갑작스런 요청 증가
        이벤트로 인한 사용자 폭증
        사용자는 응답을 받지 못한다고 항의

  이러한 상황에 CPU, 메모리 사용량을 확인해도, 문제없고 안정적으로 서비스가 운영되는 것처럼 보임
  
  이유) 
    고정 스레드 전략은 스레드 수가 고정돼있기 때문에, 사용자가 늘어나도, CPU, 메모리 사용량이 확 늘어나지 않음

    큐의 사이즈를 확인해보니 요청이 수만 건 대기..?
    요청 처리 시간보다 쌓이는 시간이 더 빠른 것  (고정 풀 전략의 큐 사이즈는 무한)
    
    결론은 서버 자원은 여유가 있으나, 처리시간보다 빠르게 작업이 쌓이고, 대기시간이 늘어남
*/