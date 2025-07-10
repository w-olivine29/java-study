package ch07atomic.sub2cas.step2spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static util.MyLogger.log;

public class SpinLock {

    // 락 존재유무 flag
    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock(){
        log("락 획득 시도");

        while(!lock.compareAndSet(false, true)){
            // 락 획득 성공할때까지 RUNNABLE 상태로 스핀 대기(바쁜 대기) -  CPU 자원을 계속 사용하면서 바쁘게 대기
            log("락 획득 실패 - 스핀 대기");
        }
        log("락 획득 완료");
    }

    // 락 반납
    public void unlock() {
        lock.set(false);
        log("락 반납 완료");
    }
}