package day5.ex3;

public class NormalAccount extends BankAccount {

    public NormalAccount(String accountNumber, String owner) {
        super(accountNumber, owner);
    }

    @Override
    boolean withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
