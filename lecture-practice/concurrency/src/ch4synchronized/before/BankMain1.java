package ch4synchronized.before;

import ch4synchronized.BankAccount;
import ch4synchronized.WithdrawTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain1 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV1(10000);

        Thread thread1 = new Thread(new WithdrawTask(account, 9000),"t1");
        Thread thread2 = new Thread(new WithdrawTask(account, 9000),"t2");
        thread1.start();
        thread2.start();

        //검증 완료까지 잠시 대기
        sleep(500);
        log("t1 state: " + thread1.getState());
        log("t2 state: " + thread2.getState());

        thread1.join();
        thread2.join();

        log("최종 잔액: " + account.getBalance());
    }
}

/*
    41.291 [       t2] 거래 시작: BankAccountV1
    41.291 [       t1] 거래 시작: BankAccountV1

    41.302 [       t1] [검증 시작] 출금액: 9000, 잔액: 10000
    41.302 [       t2] [검증 시작] 출금액: 9000, 잔액: 10000
    41.302 [       t1] [검증 완료] 출금액: 9000, 잔액: 10000
    41.303 [       t2] [검증 완료] 출금액: 9000, 잔액: 10000

    41.789 [     main] t1 state: TIMED_WAITING
    41.789 [     main] t2 state: TIMED_WAITING

    42.307 [       t1] [출금 완료] 출금액: 9000, 잔액: 1000
    42.308 [       t2] [출금 완료] 출금액: 9000, 잔액: -8000

    42.309 [       t2] 거래 종료: BankAccountV1
    42.309 [       t1] 거래 종료: BankAccountV1

    42.312 [     main] 최종 잔액: -8000

1.검증 단계에서 balance 확인
2.출금 단계 수행하기 전 다른 스레드가 출금 단계에서 balance 값 수정
3.출금 단계에서 balance 수정 (balance의 상태가 1번에서 확인한 값과 다름)
*/

/*

    56.273 [       t1] 거래 시작: BankAccountV1
    56.273 [       t2] 거래 시작: BankAccountV1

    56.285 [       t2] [검증 시작] 출금액: 9000, 잔액: 10000
    56.285 [       t1] [검증 시작] 출금액: 9000, 잔액: 10000
    56.285 [       t2] [검증 완료] 출금액: 9000, 잔액: 10000
    56.286 [       t1] [검증 완료] 출금액: 9000, 잔액: 10000

    56.761 [     main] t1 state: TIMED_WAITING
    56.761 [     main] t2 state: TIMED_WAITING

    // 두 스레드가 출금을 완전히 동시에 수행한 상황
    57.296 [       t1] [출금 완료] 출금액: 9000, 잔액: 1000
    57.296 [       t2] [출금 완료] 출금액: 9000, 잔액: 1000

    57.298 [       t2] 거래 종료: BankAccountV1
    57.298 [       t1] 거래 종료: BankAccountV1

    57.301 [     main] 최종 잔액: 1000

1.검증 단계에서 balance 확인
2.두 스레드가 동시에 출금로직 수행시작
    둘 다 1번에서 확인 한 balance와 동일한 금액으로 출금 수행
*/

/*
이러한 문제가 발생한 이유는 공유 자원을 여러 단계로 나누어 사용하기 때문

공유 자원을 사용하는 과정 (balance 필드)
1. 검증 단계 
2. 출금 단계


임계영역 (critical section)
- 여러 스레드가 동시에 접근해서는 안되는 공유 자원을 접근하거나 수정하는 부분(코드)
*/

/*
next step)
- 출금 진행 시 검증 단계부터 출금단계가 완료될 때 까지 balance의 값이 변하면 안된다.
- 이 두 단계는 한번에 하나의 스레드만 실행할 수 있도록 한다.

임계영역에 한 번에 하나의 스레드만 접근할 수 있도록 보호해야한다
-> synchronized 키워드 사용
*/