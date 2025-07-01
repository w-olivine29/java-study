package ch2control.sub4join.before;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 1~100 까지 더하는 작업을 여러 스레드가 나눠서 작업한 뒤 작업결과를 합쳐서 최종 합을 구하기
public class JoinMainV2 {
    public static void main(String[] args) {
        log("start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

        // 정확한 타이밍을 맞춰서 기다리기는 어렵다
        log("main 스레드 sleep()");
        sleep(3000);
        log("main 스레드 wake up");

        log("task.result1 = " + task1.result);
        log("task.result2 = " + task2.result);

        log("task1 + task2 = " + (task1.result + task2.result));

        log("end");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;

            log("작업 완료 result = " + result);
        }
    }


    /* 실행 순서는 보장 X

     [     main] start
     [     main] main 스레드 sleep()
     [ thread-2] 작업 시작
     [ thread-1] 작업 시작
     [ thread-2] 작업 완료 result = 3775
     [ thread-1] 작업 완료 result = 1275

     [     main] main 스레드 wake up

     [     main] task.result1 = 1275
     [     main] task.result2 = 3775
     [     main] task1 + task2 = 5050
     [     main] end

     main 스레드를 sleep() 함으로써
     의도한 대로 각 스레드가 작업을 마친 뒤 결과값을 가져올 수 있게 됐지만, 
     이러한 방식은 대기시간의 손해, 정확한 타이밍을 맞추기 어렵다

     반복문으로 계속 스레드들의 상태를 확인하는 등의 방법 또한 추천x (계속 cpu 연산 사용)

    next step)
        join 메서드를 사용해보자
    */
}
