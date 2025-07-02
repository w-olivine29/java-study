package ch2control.pratice;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

// 인터럽트 사용
public class MyPrinterV2 {
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

    /*
    인터럽트 상태를 while 문으로 체크 중인데,
    인터럽트가 발생하기 전까지 계속 CPU 에서 반복해서 수행되는 문제 -> CPU 자원 낭비
    
    jobQueue 가 비어있는데, 인터럽트 상태를 체크하는 로직에 CPU를 많이 사용 시, CPU가 필요한 스레드들의 효율이 상대적으로 떨어질 수 있음
    */
}


