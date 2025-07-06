package ch5concurrentlock.sub2reentrantlock.step1lock;

import ch4synchronized.BankAccount;
import ch4synchronized.WithdrawTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain4 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV4(10000);

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

    39.831 [       t2] 거래 시작: BankAccountV4
    39.831 [       t1] 거래 시작: BankAccountV4
    39.845 [       t2] [검증 시작] 출금액: 9000, 잔액: 10000
    39.845 [       t2] [검증 완료] 출금액: 9000, 잔액: 10000
    40.318 [     main] t1 state: WAITING
    40.318 [     main] t2 state: TIMED_WAITING  (출금 로직 내부에 sleep)
    40.856 [       t2] [출금 완료] 출금액: 9000, 잔액: 1000
    40.857 [       t1] [검증 시작] 출금액: 9000, 잔액: 1000
    40.857 [       t2] 거래 종료: BankAccountV4
    40.857 [       t1] [검증 실패] 출금액: 9000, 잔액: 1000
    40.863 [     main] 최종 잔액: 1000
*/