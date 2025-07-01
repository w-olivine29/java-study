package util;

import static util.MyLogger.log;

// 원활한 실습 위한 클래스 - run() 내부에서의 sleep 사용할때마다의 예외처리 번거로움 줄이기위함
public final class ThreadUtils {

    private ThreadUtils() {
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
