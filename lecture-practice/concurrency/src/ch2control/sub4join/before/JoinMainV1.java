package ch2control.sub4join.before;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 1~100 까지 더하는 작업을 여러 스레드가 나눠서 작업한 뒤 작업결과를 합쳐서 최종 합을 구하기
public class JoinMainV1 {
    public static void main(String[] args) {
        log("start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

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
     [ thread-1] 작업 시작
     [ thread-2] 작업 시작

    //의도한 바와는 다르게 모두 0으로 나오고 메인스레드는 종료
    // 각 스레드들이 작업이 완료되기 전에 결과를 조회한 상태
     [     main] task.result1 = 0
     [     main] task.result2 = 0
     [     main] task1 + task2 = 0
     [     main] end

     [ thread-2] 작업 완료 result = 3775
     [ thread-1] 작업 완료 result = 1275


    어떻게 해야 각 스레드의 작업이 끝날때까지 기다릴 수 있을까?
     next step)
        sleep() 을 이용해보자
    */
}
