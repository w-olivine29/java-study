package ch09executor.sub2callablefuture.step2intro;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable task = new MyCallable();

        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());

        Integer result = future.get(); // ExecutionException 발생 가능성
        log("result value = " + result);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        // Runnable의 run() 과 달리 반환타입 존재 -> 결과값을 저장할 별도의 필드 필요 x
        // throws Exception
        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);

            log("create value =" + value);
            log("Callable 완료");
            return value;
        }
    }
}

/*
    09.457 [pool-1-thread-1] Callable 시작
    11.481 [pool-1-thread-1] create value =2
    11.481 [pool-1-thread-1] Callable 완료
    11.482 [     main] result value = 2
    

next step) Future 분석

question
- 왜 바로 결과값이 아닌 Future 객체를 반환?
- 반환받은 Future 인스턴스에서 get() 을 했을 때, 작업이 미완료상태라면?
*/
