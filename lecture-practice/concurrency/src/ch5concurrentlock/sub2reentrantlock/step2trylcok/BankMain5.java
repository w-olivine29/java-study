package ch5concurrentlock.sub2reentrantlock.step2trylcok;

import ch4synchronized.BankAccount;
import ch4synchronized.WithdrawTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain5 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV5(10000);

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

/* 실행 순서 보장x

    05.102 [       t1] 거래 시작: BankAccountV5
    05.102 [       t2] 거래 시작: BankAccountV5
    05.105 [       t2] [진입 실패] 이미 처리 중인 작업이 있습니다.

    05.112 [       t1] [검증 시작] 출금액: 9000, 잔액: 10000
    05.113 [       t1] [검증 완료] 출금액: 9000, 잔액: 10000
    05.589 [     main] t1 state: TIMED_WAITING
    05.589 [     main] t2 state: TERMINATED // t2는 lock 획득 실패 후 다시 시도하지 않고 스레드 종료
    
    06.126 [       t1] [출금 완료] 출금액: 9000, 잔액: 1000
    06.127 [       t1] 거래 종료: BankAccountV5
    06.130 [     main] 최종 잔액: 1000

*/