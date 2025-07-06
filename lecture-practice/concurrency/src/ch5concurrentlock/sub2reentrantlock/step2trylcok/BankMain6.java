package ch5concurrentlock.sub2reentrantlock.step2trylcok;

import ch4synchronized.BankAccount;
import ch4synchronized.WithdrawTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain6 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV6(10000);

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

    04.615 [       t2] 거래 시작: BankAccountV6
    04.616 [       t1] 거래 시작: BankAccountV6
    04.628 [       t2] [검증 시작] 출금액: 9000, 잔액: 10000
    04.628 [       t2] [검증 완료] 출금액: 9000, 잔액: 10000
    05.105 [     main] t1 state: TIMED_WAITING // tryLock(시간) 중
    05.105 [     main] t2 state: TIMED_WAITING // 출금 로직 내부의 sleep 때문
    05.119 [       t1] [진입 실패] 이미 처리 중인 작업이 있습니다.  //TIMED_WAITING -> RUNNABLE
    05.640 [       t2] [출금 완료] 출금액: 9000, 잔액: 1000
    05.641 [       t2] 거래 종료: BankAccountV6
    05.645 [     main] 최종 잔액: 1000
*/