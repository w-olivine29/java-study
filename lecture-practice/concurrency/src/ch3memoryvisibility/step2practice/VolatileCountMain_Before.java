package ch3memoryvisibility.step2practice;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain_Before {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        thread.start();

        sleep(1000);

        task.flag = false;
        log(String.format("flag= %s, count= %d in main", task.flag, task.count));

    }

    static class MyTask implements Runnable {

        boolean flag = true;
        long count;

        @Override
        public void run() {
            while(flag){
                count++;
                // 1억번에 한번 씩 출력
                if(count % 100_000_000 == 0){
                    log(String.format("flag= %s, count= %d in while()", flag, count));
                }
            }
            log(String.format("flag= %s, count= %d 종료", flag, count));
        }
    }
}

/* 출력순서 보장 x

    317 [     work] flag= true, count= 100000000 in while()
    412 [     work] flag= true, count= 200000000 in while()
    504 [     work] flag= true, count= 300000000 in while()
    595 [     work] flag= true, count= 400000000 in while()
    686 [     work] flag= true, count= 500000000 in while()
    777 [     work] flag= true, count= 600000000 in while()
    863 [     work] flag= true, count= 700000000 in while()
    951 [     work] flag= true, count= 800000000 in while()
    041 [     work] flag= true, count= 900000000 in while()
    130 [     work] flag= true, count= 1000000000 in while()

    main 스레드에서 task.flag = false;

    이 부분 살펴보기
    214 [     main] flag= false, count= 1092112405 in main
    222 [     work] flag= true, count= 1100000000 in while()
    222 [     work] flag= false, count= 1100000000 종료


    work 스레드가 flag 값을 false로 확인한 시점
        콘솔에 결과 출력
        -> 스레드가 잠시 대기 -> 컨텍스트 스위칭
         -> 캐시 메모리 갱신 (무조건 보장은 아님) 
         -> 출력이 끝나고, 다시 메인메모리에서 값을 가지러 갈 때 false로 바뀐 것을 확인
*/