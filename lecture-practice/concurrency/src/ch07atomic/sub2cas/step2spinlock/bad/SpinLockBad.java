package ch07atomic.sub2cas.step2spinlock.bad;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockBad {

    // 락 존재유무 flag
    private volatile boolean lock = false;

    public void lock(){
        log("락 획득 시도");

        // 임계영역 보호되지 않는 상태
        // 락 사용여부, 락 값 변경의 과정이 원자적이지 않음
        while(true){
            if(!lock){ // 1. 락 사용 여부 체크
                sleep(100); // 문제 상황 시나리오 (스레드 대기)
                lock = true; // 2. 락 획득
                break;
            }else {
                // 락 획득 성공할때까지 RUNNABLE 상태로 스핀 대기(바쁜 대기)
                log("락 획득 실패 = 스핀 대기");

            }
        }
        log("락 획득 완료");
    }

    // 락 반납
    public void unlock() {
        lock = false; // 원자적 연산
        log("락 반납 완료");
    }
}
