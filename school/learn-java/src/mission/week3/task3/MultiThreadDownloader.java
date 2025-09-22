package mission.week3.task3;

import java.util.*;

/* 3. 파일 다운로드 시스템
- 멀티스레드
- Thread & Runnable
*/

// 41기 유도경
public class MultiThreadDownloader {
    public static void main(String[] args) {

        // 다운로드 대기목록 세팅
        Queue<String> downloadQueue = new ArrayDeque<>();
        for (int i = 1; i <= 100; i++) {
            downloadQueue.add(String.format("파일_%d.%s", i, "pdf"));
        }

        MultiThreadDownloader downloader = new MultiThreadDownloader(downloadQueue);

        try {
            downloader.multiThreadDownloadAll();
            System.out.println(Arrays.toString(downloader.getCheckCompleted()));

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("프로그램 종료");
        }

    }


    private Queue<String> downloadQueue;
    private String[] checkCompleted; // 단순 실습 결과 확인용

    public MultiThreadDownloader(Queue<String> downloadQueue) {
        this.downloadQueue = downloadQueue;
        this.checkCompleted = new String[downloadQueue.size()];
    }


    public void multiThreadDownloadAll() throws InterruptedException {
        int threadCount = getSettingThreadCount();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> { // Runnable 구현

                // 모두 다운로드할 때까지 반복
                while (true) {
                    synchronized (this) {
                        if (downloadQueue.isEmpty()) break; // 모두 다운로드했다면 중지
                    }
                    download();
                }
            });
            threads.add(thread);
            thread.start();
        }

        // 모든 작업이 끝날때까지 대기
        for (Thread thread : threads) {
            thread.join();
        }
    }


    private void download() {

        String file = null;
        synchronized (this) {
            if (!downloadQueue.isEmpty()) {
                file = downloadQueue.poll();
            }
        }
        if (!Objects.isNull(file)) {
            System.out.printf("[%s] %s 다운로드 시작\n", Thread.currentThread().getName(), file);

            try {
                Thread.sleep(10000);  // 다운로드 시 10초 소요 가정
                System.out.printf("[%s] %s 다운로드 완료\n", Thread.currentThread().getName(), file);
                checkComplete(file, true); // 실습결과 체크용

            } catch (InterruptedException e) {
                System.out.println("다운로드 중지");
                System.out.println(e.getMessage());
                checkComplete(file, false);
            }
        }
    }

    // 최적 스레드 개수
    // I/O 작업 (파일 처리, 네트워크 처리 등) -> (코어 개수 * 2) or (I/O 시간을 고려하여 더 많은 스레드)
    private static int getSettingThreadCount() {
        System.out.println("Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors()); // 체크용
        return Runtime.getRuntime().availableProcessors() * 2;
    }


    public String[] getCheckCompleted() {
        return checkCompleted;
    }

    private void checkComplete(String file, boolean result) {
        int fileNumber = Integer.parseInt(file.substring(file.indexOf("_") + 1, file.indexOf(".")));
        if(result){
            checkCompleted[fileNumber - 1] = fileNumber + "";
        }else {
            checkCompleted[fileNumber - 1] = fileNumber + "(fail)";
        }
    }
}
