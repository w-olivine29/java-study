package ch4synchronized.after.step2codeblock;

import ch4synchronized.BankAccount;
import ch4synchronized.WithdrawTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain3 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV3(10000);

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

/* 순서 보장x

    33.691 [       t2] 거래 시작: BankAccountV3
    33.691 [       t1] 거래 시작: BankAccountV3

    33.704 [       t2] [검증 시작] 출금액: 9000, 잔액: 10000
    33.704 [       t2] [검증 완료] 출금액: 9000, 잔액: 10000
    34.181 [     main] t1 state: BLOCKED
    34.182 [     main] t2 state: TIMED_WAITING
    34.706 [       t2] [출금 완료] 출금액: 9000, 잔액: 1000
    34.706 [       t1] [검증 시작] 출금액: 9000, 잔액: 1000
    34.706 [       t2] 거래 종료: BankAccountV3
    34.706 [       t1] [검증 실패] 출금액: 9000, 잔액: 1000
    34.709 [     main] 최종 잔액: 1000
*/

/*
자바에서의 동기화는 여러 스레드가 동시에 접근할 수 있는 자원에 대해 일관성있고 안전한 접근을 보장하기 위한 메커니즘

동기화 사용시 해결되는 문제
- 경합조건(Race condition): 두 개 이상의 스레드가 경쟁적으로 동일한 자원을 수정할 때 발생하는 문제
- 데이터 일관성: 여러스레드가 동시에 읽고 쓰는 데이터의 일관성 유지
*/

/* synchronized 단점
- 무한대기 (BLOCKED 상태인 스레드는 lock이 풀릴 때까지 무한 대기)
    - 타임아웃 적용 x
    - 중간에 인터럽트 x
- 공정성 문제
    - 여러 스레드 중에 어떤 스레드가 락을 획득할 지 예측 불가
    - 최악의 경우 특정 스레드만 오래 락을 획득 못할 수도 있음
    
 -> 더 유연, 세밀한 제어가 가능한 방법 도입
 -> java.util.concurrent 패키지 추가
*/