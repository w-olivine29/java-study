package ch2control.pratice;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 상태 변수 사용
public class MyPrinterV1 {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");

        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("프린터할 문서을 입력하세요. 종료 (q)");

            String input = userInput.nextLine();
            if (input.equals("q")) {
                printer.work = false; //프린터 종료
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {
        
        // 여러스레드가 동시에 접근하는 변수에는 volatile 키워드를 붙여야 안전
        volatile boolean work = true;
        private final Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); //동시성컬렉션

        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String job = jobQueue.poll();
                log(String.format("출력시작: %s, 대기문서: %s", job, jobQueue));
                sleep(3000); //출력 하는데 3초 걸린다고 가정
                log("출력 완료");
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }

    /*
     q(종료)입력 시 바로 반응하지 않는 단점 존재 (다시 while문 체크하기까지 최대3초 소요가능)
     
     next step) 
        인터럽트를 도입해 반응성 문제 해결
    */
}


