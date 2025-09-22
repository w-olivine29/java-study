package day6;


public class BankAccount {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("211-910", 10);
        bankAccount.withdraw(500);
    }


    private final String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금액은 0보다 커야 합니다.");
        }
        if (balance < amount) {
            throw new InsufficientBalanceException(String.format("[잔액부족] 현재잔액: %d원", amount));
        }

        balance -= amount;
        System.out.printf("%d원 출금 - 현재잔액: %d원", amount, balance);
    }
}
