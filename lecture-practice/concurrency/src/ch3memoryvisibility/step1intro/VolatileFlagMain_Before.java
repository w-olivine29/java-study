package ch3memoryvisibility.step1intro;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain_Before {
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

        boolean runFlag = true;

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

    688 [     main] runFlag = true
    691 [     work] task 시작
    702 [     main] runFlag -> false 변경시도
    703 [     main] runFlag = false
    ... 계속 실행중

    runFlag 가 false 가 됐음에도, work 스레드가 while 문에서 빠져나오지 못하고 있다.


    원인)
    현대의 cpu는 코어 단위로 캐시 메모리를 각각 보유 (공유 캐시 메모리도 있음)


    CPU 코어1 (main 스레드)    CPU 코어2 (work 스레드)
    ┌─────────────────┐      ┌─────────────────┐
    │   L1 캐시        │      │   L1 캐시        │
    │ runFlag = false │      │ runFlag = true  │ ← 아직 업데이트 안됨
    └─────────────────┘      └─────────────────┘
            │                          │  메인메모리에 반영된 runFlag 값을 언제 다시 캐시 메모리에 불러올지는 미지수 (cpu 설계 방식, 종류에 따라 상이)
            └────────┬─────────────────┘
                     │
                ┌─────────────────┐
                │   메인 메모리     │
                │ runFlag = false │ ← 실제로는 업데이트됨
                └─────────────────┘

 주로 컨텍스트 스위칭이 될 때 캐시메모리도 함께 갱신되지만, 환경에 따라 달라질 수 있음
 
 메모리 가시성: 멀티스레드 환경에서 한 스레드가 변경한 값이 다른 스레드에서 언제 보이는지에 대한 문제 (메모리에 변경한 값이 보이는가, 보이지 않는가의 문제)

 next step)  한 스레드에서 변경한 값이 다른 스레드에서 즉시 보이게 하려면 어떻게 해야하는가?
    volatile 키워드 사용
*/
