package ch09executor.sub3strategy.step2threadpoolsize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static util.ExecutorUtils.printState;


public class PreStartPoolMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        printState(es); //[pool= 0, active= 0, queuedTasks= 0, completedTask= 0]

        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        poolExecutor.prestartAllCoreThreads(); // 미리 스레드를 생성해놓는다.

        printState(es); //[pool= 100, active= 0, queuedTasks= 0, completedTask= 0]

        es.close();
    }
}

/*
 미리 스레드를 생성하는 이유:
     1. 첫 번째 작업부터 즉시 실행 (스레드 생성 지연 시간 제거)
     2. 일관된 응답 시간 보장 (Cold Start 방지)
     3. 고부하 상황에서 스레드 생성 경합 방지
     4. 성능 예측 가능성 향상

 주의점:
     - 초기 메모리 사용량 증가 (스레드당 약 1MB 스택 메모리)
     - 실제 사용하지 않는 스레드도 미리 생성될 수 있음
     - 응답 시간이 중요한 시스템에서만 사용 권장
*/