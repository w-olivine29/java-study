package ch4synchronized.after.step1method;

import ch4synchronized.BankAccount;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    //메서드 동기화 -> 해당 메서드는 한 번에 하나의 스레드만 실행 가능
    // synchronized 안에서 접근하는 변수의 메모리 가시성 문제는 해결
    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작: " + this.getClass().getSimpleName());

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

        log("거래 종료: " + this.getClass().getSimpleName());

        return true;
    }

    // 다른 스레드가 동기화된 withdraw() 호출 중이면  getBalance() 도 수행 못함
    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
