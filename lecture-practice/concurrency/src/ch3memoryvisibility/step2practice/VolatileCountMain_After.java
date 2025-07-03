package ch3memoryvisibility.step2practice;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain_After {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        thread.start();

        sleep(1000);

        task.flag = false;
        log(String.format("flag= %s, count= %d in main", task.flag, task.count));

    }

    static class MyTask implements Runnable {

        volatile boolean flag = true;
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

/* 출력순서 & 결과 보장 x

     [     work] flag= true, count= 100000000 in while()
     [     work] flag= true, count= 200000000 in while()
     [     work] flag= true, count= 300000000 in while()
     [     work] flag= true, count= 400000000 in while()
     [     work] flag= true, count= 500000000 in while()
     [     work] flag= true, count= 600000000 in while()
     [     work] flag= true, count= 700000000 in while()
     [     work] flag= true, count= 800000000 in while()
     [     work] flag= true, count= 900000000 in while()
     [     work] flag= true, count= 1000000000 in while()
     [     main] flag= false, count= 1042902047 in main
     [     work] flag= false, count= 1042902047 종료
*/