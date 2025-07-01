package ch2control.sub4join.after;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 1~100 까지 더하는 작업을 여러 스레드가 나눠서 작업한 뒤 작업결과를 합쳐서 최종 합을 구하기
public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

        log("join(1000) - main 스레드가 thread1, thread2 종료까지 대기하되, (최대 1초) ");

        // main스레드 - TIMED_WAITING 상태
        thread1.join(1000);
        thread2.join(1000);
        log("main 스레드 대기 완료");

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
     [     main] join(1000) - main 스레드가 thread1, thread2 종료까지 대기하되, (최대 1초)
     [ thread-1] 작업 시작
     [ thread-2] 작업 시작
     [     main] main 스레드 대기 완료
     [     main] task.result1 = 1275
     [ thread-1] 작업 완료 result = 1275
     [ thread-2] 작업 완료 result = 3775
     [     main] task.result2 = 3775
     [     main] task1 + task2 = 5050
     [     main] end


    */
}
