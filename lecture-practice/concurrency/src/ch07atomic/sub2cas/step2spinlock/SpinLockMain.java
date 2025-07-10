package ch07atomic.sub2cas.step2spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockMain {
    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {

                spinLock.lock();
                try {
                    // 임계 영역
                    log("비즈니스 로직 실행");
                    sleep(1); // 오래 걸리는 로직에서는 스핀 락 사용 x
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

sleep() 사용하지 않은 코드 실행 ( 오래걸리지 않는 비즈니스 로직 가정)

    31.314 [ Thread-0] 락 획득 시도
    31.314 [ Thread-1] 락 획득 시도
    31.423 [ Thread-1] 락 획득 완료
    31.423 [ Thread-0] 락 획득 완료
    31.423 [ Thread-0] 비즈니스 로직 실행
    31.423 [ Thread-1] 비즈니스 로직 실행
    31.423 [ Thread-0] 락 반납 완료
    31.424 [ Thread-1] 락 반납 완료
    
 락 접근 & 락 상태변경 과정을 원자적으로 변경
 
 원자적인 연산은 스레드 입장에서 분리할 수 없는 하나의 연산 -> 여러 스레드가 동시에 실행해도 안전
 CAS를 활용한 덕분에 무거운 동기화 작업 없이 가벼운 락 구현 가능

 동기화 락 사용하는 경우 BLOCKED, WAITING 상태로 변한 스레드를 다시 깨우는 과정이 필요 (컨텍스츠 스위칭 발생) -> 상대적으로 성능이 느릴 수 있음
*/

/* 순서 보장 x

sleep() 사용 코드 실행( 오래걸리는 비즈니스 로직 가정)

    25.433 [ Thread-0] 락 획득 시도
    25.433 [ Thread-1] 락 획득 시도
    25.435 [ Thread-0] 락 획득 완료
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.435 [ Thread-0] 비즈니스 로직 실행
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.435 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.436 [ Thread-1] 락 획득 실패 - 스핀 대기
    25.437 [ Thread-1] 락 획득 완료
    25.437 [ Thread-0] 락 반납 완료
    25.437 [ Thread-1] 비즈니스 로직 실행
    25.439 [ Thread-1] 락 반납 완료
    
    락 획득 대기중인 스레드가 BLOCKED, WAITING 상태로 바뀌진 않지만, 
    RUNNABLE 상태로 락을 획득할때까지 반복문을 반복
     -> 락 획득 대기 하면서 스레드가 CPU 를 계속 사용 중
     
    스핀락은 안전한 임계영역이 필요하지만, 연산이 길지 않고 매우 짧은 로직을 수행할때 사용해야한다.
    good) 숫자 값 증가, 자료 구조 데이터 추가 등의 CPU 사이클이 짧게 끝나는 연산
    bad) 데이터베이스 결과 대기, 타 서버 요청 대기 등의 오래 기다리는 작업

    ms 단위 이하로 될때만 사용하는 것을 권장

    일반적으로는 동기화 락 사용, 특별한 경우에 한정해서 CAS를 활용하여 최적화

    스핀 락:
    락 획득을 위해 자원을 소모하면서 반복적으로 확인하는 락 매커니즘
    CAS를 사용해서 구현 가능

    락과 스핀락의 장단점, 실무예시는 pdf 로 복습필수
*/
