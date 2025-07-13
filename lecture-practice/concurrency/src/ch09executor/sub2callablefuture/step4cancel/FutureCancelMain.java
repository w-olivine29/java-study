package ch09executor.sub2callablefuture.step4cancel;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureCancelMain {

    // 변경해가며 실습
    //private static boolean mayInterruptIfRunning = true;
    private static boolean mayInterruptIfRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future state: " + future.state());

        //일정 시간 후 취소 시도
        sleep(3000);

        //cancel() 호출
        log(String.format("future cancel(%b) 호출", mayInterruptIfRunning));
        boolean cancelResult = future.cancel(mayInterruptIfRunning);
        log(String.format("future cancel(%b) result: %b", mayInterruptIfRunning, cancelResult));


        //결과 확인
        try {
            log("Future result: " + future.get());
        } catch (CancellationException e) {
            log("Future는 이미 취소되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        es.close();
    }

    static class MyTask implements Callable<String> {
        @Override
        public String call() {

            try {
                for (int i = 0; i < 10; i++) {
                    log("작업 중: " + i);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                log("인터럽트 발생");

                return "Interrupted";
            }

            return "Completed";
        }
    }

}
/* mayInterruptIfRunning = true
    48.260 [     main] Future state: RUNNING
    48.260 [pool-1-thread-1] 작업 중: 0
    49.266 [pool-1-thread-1] 작업 중: 1
    50.278 [pool-1-thread-1] 작업 중: 2
    51.272 [     main] future cancel(true) 호출
    51.272 [pool-1-thread-1] 인터럽트 발생
    51.272 [     main] future cancel(true) result: true
    51.273 [     main] Future는 이미 취소되었습니다.
    
   작업이 실행중이라면 Thread.interrupt() 호출 -> 작업 중단
*/

/* mayInterruptIfRunning = false
    37.451 [pool-1-thread-1] 작업 중: 0
    37.451 [     main] Future state: RUNNING
    38.462 [pool-1-thread-1] 작업 중: 1
    39.466 [pool-1-thread-1] 작업 중: 2
    40.457 [     main] future cancel(false) 호출
    40.457 [     main] future cancel(false) result: true
    40.457 [     main] Future는 이미 취소되었습니다.
    40.472 [pool-1-thread-1] 작업 중: 3
    41.486 [pool-1-thread-1] 작업 중: 4
    42.495 [pool-1-thread-1] 작업 중: 5
    43.504 [pool-1-thread-1] 작업 중: 6
    44.518 [pool-1-thread-1] 작업 중: 7
    45.528 [pool-1-thread-1] 작업 중: 8
    46.537 [pool-1-thread-1] 작업 중: 9

    이미 실행 중인 작업은 중단 x
*/