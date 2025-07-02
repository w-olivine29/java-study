package ch2control.pratice;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

// yield 도입
public class MyPrinterV3 {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");

        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("프린터할 문서을 입력하세요. 종료 (q)");

            String input = userInput.nextLine();
            if (input.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        private final Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); //동시성컬렉션

        @Override
        public void run() {

            while (!Thread.interrupted()) { // 인터럽트 상태 확인 & false로 상태 복원
                if (jobQueue.isEmpty()) {
                    Thread.yield(); // yield 도입 - jobQueue가 비어있을 때, 바로 인터럽트 상태를 체크하지 않고 다른 스레드에게 양보
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log(String.format("출력시작: %s, 대기문서: %s", job, jobQueue));
                    Thread.sleep(3000); //출력 하는데 3초 걸린다고 가정
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("인터럽트 발생");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }

}


