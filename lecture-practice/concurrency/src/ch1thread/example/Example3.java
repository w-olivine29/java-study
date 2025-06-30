package ch1thread.example;

import static util.MyLogger.log;

/* Runnable 익명 클래스 구현
문제2 익명클래스로 구현
*/
public class Example3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    log("value: " + i);

                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        log(e);
                    }
                }
            }
        };

        Thread thread = new Thread(runnable, "counter");
        thread.start();
    }
}
