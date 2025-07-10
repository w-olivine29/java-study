package ch07atomic.sub2cas.step2spinlock.bad;

import ch07atomic.sub2cas.step2spinlock.SpinLock;

import static util.MyLogger.log;

public class SpinLockBadMain {
    public static void main(String[] args) {
        SpinLockBad spinLock = new SpinLockBad();

        Runnable task = new Runnable() {
            @Override
            public void run() {

                spinLock.lock();
                try {
                    // 임계 영역
                    log("비즈니스 로직 실행");
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

    }
}

/* 순서 보장 x

    12.543 [ Thread-0] 락 획득 시도
    12.543 [ Thread-1] 락 획득 시도
    12.544 [ Thread-0] 락 획득 완료
    12.544 [ Thread-1] 락 획득 실패 - 스핀 대기
    12.545 [ Thread-0] 비즈니스 로직 실행
    12.545 [ Thread-1] 락 획득 실패 - 스핀 대기
    12.545 [ Thread-0] 락 반납 완료
    12.545 [ Thread-1] 락 획득 완료
    12.545 [ Thread-1] 비즈니스 로직 실행
    12.545 [ Thread-1] 락 반납 완료

next step)

*/
