package ch09executor.sub2callablefuture.step5exception;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// Future get() -> 작업 결과값 or 예외 반환
public class FutureExceptionMain {
    public static void main(String[] args) {

        try (ExecutorService es = Executors.newFixedThreadPool(1)) {
            log("작업 전달");
            Future<Integer> future = es.submit(new ExCallable());
            sleep(1000); // 작업 대기 (Future의 상태를 보기 위함)
            log("future.get() 호출 시도, future.state(): " + future.state());

            Integer result = future.get();
            log("result value = " + result);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        } catch (ExecutionException e) { //실행 중에 발생한 예외
            log("e= " + e);
            Throwable cause = e.getCause(); //원본 예외
            log("cause = " + cause);
        }
    }

    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("예외 발생"); // 예외 발생 가정
        }
    }
}
/*
    55.253 [     main] 작업 전달
    55.257 [pool-1-thread-1] Callable 실행, 예외 발생
    56.267 [     main] future.get() 호출 시도, future.state(): FAILED
    56.267 [     main] e= java.util.concurrent.ExecutionException: java.lang.IllegalStateException: 예외 발생
    56.269 [     main] cause = java.lang.IllegalStateException: 예외 발생


[작업 스레드]
    ExCallable 수행 중  IllegalStateException 발생
    작업 스레드는 Future에 발생한 예외를 담아둔다. (필드에 보관)
    Future의 상태 -> FAILED

[요청 스레드]
    future.get() 호출
    해당 Future의 상태가 FAILED -> ExecutionException 발생
    ExecutionException 은 Future를 저장해둔 IllegalStateException를 포함한 상태
    ExecutionException getCause() -> 작업 수행 중 발생한 원본 예외 가져올 수 있음
    
Future의 get() 은 작업결과 or 예외를 받을 수 있음
*/