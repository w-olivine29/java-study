package ch4synchronized.before;

import ch4synchronized.BankAccount;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {

    private int balance;

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
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

    @Override
    public int getBalance() {
        return balance;
    }
}
