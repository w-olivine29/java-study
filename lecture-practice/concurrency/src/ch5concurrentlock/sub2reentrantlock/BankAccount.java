package ch5concurrentlock.sub2reentrantlock;

public interface BankAccount {
    
    // 계좌 잔액이 출금 금액보다 적다면 실패, false 반환
    boolean withdraw(int amount);

    int getBalance();
}
