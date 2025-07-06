package ch5concurrentlock.sub2reentrantlock.step2trylcok;

import ch4synchronized.BankAccount;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// preVersion) BankAccountV4 - ReentrantLock lock() 적용
// currentVersion) BankAccountV5 - ReentrantLock tryLock() 적용
public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    //  동기화 -> 는 한 번에 하나의 스레드만 실행 가능
    // 한 번에 하나의 스레드만 실행함으로써 성능이 떨어질 수 있기때문에, 꼭 필요한 구간으로 한정해서 설정
    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + this.getClass().getSimpleName());

        if(!lock.tryLock()){
            log("[진입 실패] 이미 처리 중인 작업이 있습니다.");
            return false;
        }

        try {
            // 임계 영역 시작 ===================================================

            // this 의 인스턴스 lock 획득
            log(String.format("[검증 시작] 출금액: %d, 잔액: %d", amount, balance));

            // 잔고가 출금금액보다 적으면 진행 x
            if (balance < amount) {
                log(String.format("[검증 실패] 출금액: %d, 잔액: %d", amount, balance));
                return false;
            }

            // 잔고가 출금액 보다 많으면 정상진행
            log(String.format("[검증 완료] 출금액: %d, 잔액: %d", amount, balance));
            sleep(1000); //출금 진행 시간으로 가정

            this.balance -= amount;
            log(String.format("[출금 완료] 출금액: %d, 잔액: %d", amount, balance));

            // 임계 영역 종료 ===================================================
        } finally { // lock() -> 반드시 lock.unlock() 호출!!!!
            lock.unlock();  // unlock 해주지 않으면 WAITING 상태 해제 불가 (임계 영역 내에서 예외 등이 발생하면..?)
        }

        log("거래 종료: " + this.getClass().getSimpleName());
        return true;
    }


    @Override
    public int getBalance() {

        lock.lock();
        try{
            return balance;
        }finally{
            lock.unlock();
        }
    }
}
