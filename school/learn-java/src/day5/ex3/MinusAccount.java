package day5.ex3;

public class MinusAccount extends BankAccount {

    private int minusLimit;

    public MinusAccount(String accountNumber, String owner, int minusLimit) {
        super(accountNumber, owner);
        this.minusLimit = minusLimit;
    }

    boolean withdraw(int amount) {
        // 잔액 + 마이너스 한도액까지 출금 가능
        if (amount > 0 && balance + minusLimit >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
