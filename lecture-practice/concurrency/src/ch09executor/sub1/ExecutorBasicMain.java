package ch09executor.sub1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static ch09executor.ExecutorUtils.*;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/* ThreadPoolExecutor 속성 종류
- int corePoolSize
    스레드 풀에서 관리되는 기본 스레드의 수
- int maximumPoolSize
    스레드 풀에서 관리되는 최대 스레드 수

- long keepAliveTime
- TimeUnit unit
    기본 스레드 수를 초과해서 만들어진 스레드가 생존할 수 있는 대기 시간
    이 시간동안 처리할 작업이 없다면 초과 스레드는 제거

- BlockingQueue<Runnable> workQueue)
    작업을 보관할 블로킹 큐
*/
public class ExecutorBasicMain {
    public static void main(String[] args) {


        ExecutorService es = new ThreadPoolExecutor(
                2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // 블로킹큐에 작업을 메모리가 허용하는 선에서 무제한으로 넣을 수 있고,
        // 블로킹 큐에서 작업을 꺼내려할 때  없으면 스레드는 기다림
        log("== 초기 상태 ==");
        printState(es); //[pool= 0, active= 0, queuedTasks= 0, competedTask= 0] - 작업이 하나라도 들어와야 스레드 생성시작
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));
        log("== 작업 수행 중 ==");
        printState(es); //[pool= 2, active= 2, queuedTasks= 2, competedTask= 0]

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es); //[pool= 2, active= 0, queuedTasks= 0, completedTask= 4]

        es.close(); // 19미만 버전은 shutdown()
        log("== shutdown 완료 ==");
        printState(es);
    }
}

/* 실행 순서 보장 x

new ThreadPoolExecutor(
                2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>())

corePoolSize: 2
maximumPoolSize: 2


    37.151 [     main] == 초기 상태 ==
    37.163 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 0]
    37.165 [     main] == 작업 수행 중 ==
    37.165 [     main] [pool= 2, active= 2, queuedTasks= 2, completedTask= 0]
    37.166 [pool-1-thread-1] taskA시작
    37.166 [pool-1-thread-2] taskB시작
    38.172 [pool-1-thread-2] taskB완료
    38.172 [pool-1-thread-1] taskA완료
    
    // 여기서부터는 앞서 생성한 스레드 재사용
    38.173 [pool-1-thread-2] taskC시작
    38.173 [pool-1-thread-1] taskD시작
    39.178 [pool-1-thread-2] taskC완료
    39.178 [pool-1-thread-1] taskD완료
    40.181 [     main] == 작업 수행 완료 ==
    40.181 [     main] [pool= 2, active= 0, queuedTasks= 0, completedTask= 4]
    40.182 [     main] == shutdown 완료 ==
    40.183 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 4] -> 풀에 대기하던 스레드도 함께 제거
*/


/*
 초기 상태 ->  스레드 0개 (스레드를 미리 만들어두는 것이 아님)
 1번작업 들어옴 (최초의 작업) -> 스레드 1개 생성 & 수행
 2번작업 들어옴 -> 스레드 1개 생성 & 수행
 (작업이 들어올 때마다 corePoolSize 까지만 스레드를 생성)

 이 시점에서 스레드가 총 2개 만들어져있는 상태

 작업이 끝나면 스레드를 스레드풀에 반납 (RUNNABLE -> WAITING)
 (실제로 반납되는 개념이 아니라, 스레드의 상태가 변경되는 것)

 3,4번 작업이 들어올때는 -> 이미 만들어져있던 스레드 중 기존 작업완료한 스레드 재사용
*/

