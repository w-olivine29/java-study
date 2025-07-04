package ch4synchronized.after.step1method;

import ch4synchronized.BankAccount;
import ch4synchronized.WithdrawTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain2 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV2(10000);

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
모든 인스턴스는 자신만의 lock 을 가지고있음 (모니터 락)
스레드가 synchronized 키워드가 있는 메서드에 진입하려면 해당 인스턴스의 lock을 가지고있어야함


락을 획득하는 순서는 보장x

    02.472 [       t1] 거래 시작: BankAccountV2 -> (t1스레드가 먼저 lock 획득)
    02.482 [       t1] [검증 시작] 출금액: 9000, 잔액: 10000
    02.483 [       t1] [검증 완료] 출금액: 9000, 잔액: 10000
    02.961 [     main] t1 state: TIMED_WAITING
    02.961 [     main] t2 state: BLOCKED  -> (t2스레드가 lock을 획득할때까지 BLOCKED 상태로 무한정 대기  - cpu 스케줄링에 들어가지 않음)
    03.484 [       t1] [출금 완료] 출금액: 9000, 잔액: 1000
    03.484 [       t1] 거래 종료: BankAccountV2 -> (t1은 lock을 반납하면서 출금 수행완료)

    03.485 [       t2] 거래 시작: BankAccountV2 -> (t2 스레드가 lock 획득)
    03.485 [       t2] [검증 시작] 출금액: 9000, 잔액: 1000
    03.486 [       t2] [검증 실패] 출금액: 9000, 잔액: 1000

    03.497 [     main] 최종 잔액: 1000
*/
