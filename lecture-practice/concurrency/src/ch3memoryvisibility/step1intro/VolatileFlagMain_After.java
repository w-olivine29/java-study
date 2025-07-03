package ch3memoryvisibility.step1intro;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain_After {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task,"work");
        log("runFlag = " + task.runFlag);

        thread.start();

        sleep(1000);
        log("runFlag -> false 변경시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
    }

    static class MyTask implements Runnable {

        // volatile: 값을 읽을 때 캐시메모리를 사용하지 않고 항상 메인 메모리에 접근
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");

            // runFlag가 false면  탈출
            while (runFlag) {
                /* while문 안에 아무것도 안 넣은 이유: 메모리 가시성 문제 시나리오를 위함

                메모리 가시성 문제 시나리오 구현 실패)
                 출력, sleep 등의 작업 -> 컨텍스츠 스위칭 -> 캐시메모리 무효화/갱신 -> 메인 메모리에 다시 읽어옴 (but 항상 보장되는 것은 아님)
                * */
            }
            log("task 종료");
        }
    }
}

/* 실행 순서 보장 x

    605 [     main] runFlag = true
    608 [     work] task 시작
    613 [     main] runFlag -> false 변경시도
    614 [     main] runFlag = false
    613 [     work] task 종료


    여러 스레드에서 같은 시점에 정확히 같은 데이터를 보는 것이 중요한 상황에서는
    성능을 약간 포기하고, 값을 읽을 떄 모두 직접 메인 메모리에 접근
    
    여러 스레드에서 같은 값을 읽고 써야할 경우 volatile 키워드를 사용
    주의: 성능이 느려지기 때문에 꼭 필요한 곳에만 사용
*/
