package day5.ex3;

public abstract class BankAccount {
    // 필드
    private static int totalAccounts; // 전체 계좌 수
    private String accountNumber;
    private String owner;
    protected int balance;

    // 생성자
    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
        totalAccounts++;
    }

    // 메소드
    // 1. 입금
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 2. 출금 (추상 메소드로 변경 -> 계좌 종료별로 구현을 다르게 하기 위함)
    abstract boolean withdraw(int amount);

    // 3. 잔액 조회
    public int getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }


}

