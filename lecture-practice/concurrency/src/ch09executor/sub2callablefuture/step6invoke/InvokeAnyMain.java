package ch09executor.sub2callablefuture.step6invoke;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class InvokeAnyMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(10);

        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 2000);
        CallableTask task3 = new CallableTask("task3", 3000);

        //<T> T invokeAny(Collection<? extends Callable<T>> tasks)
        // 작업들 중에 하나라도 끝나면, 그걸 바로 반환 & 나머지 취소처리
        Integer value = es.invokeAny(List.of(task1, task2, task3));
        log("value = " + value);

        es.close();
    }
}
/*

    34.994 [pool-1-thread-2] task2실행
    34.994 [pool-1-thread-3] task3실행
    34.994 [pool-1-thread-1] task1실행

    36.009 [pool-1-thread-1] task1완료
    36.010 [     main] value = 1000
    36.010 [pool-1-thread-2] 인터럽트 발생, sleep interrupted
    36.010 [pool-1-thread-3] 인터럽트 발생, sleep interrupted



<T> T invokeAny(Collection<? extends Callable<T>> tasks)
   작업들 중에 하나라도 끝나면, 그걸 바로 반환 & 나머지 취소처리
   활용 예시: 다중 DB 조회, 지역별 서버 호출, 여러 알고리즘 중 빠른 것 선택, 외부 서비스 장애 대응 등
   장점: 응답시간 최적화, 장애 복구, 리소스 효율성
*/