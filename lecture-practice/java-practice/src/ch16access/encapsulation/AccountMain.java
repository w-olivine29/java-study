package ch16access.encapsulation;

public class AccountMain {
    public static void main(String[] args) {

        Account account = new Account();
        account.withdraw(10000);
        System.out.println("현재잔액:" + account.getBalance());

        account.deposit(10000);
        System.out.println("현재잔액:" + account.getBalance());

        account.withdraw(10000);
        System.out.println("현재잔액:" + account.getBalance());

        account.withdraw(0);
        System.out.println("현재잔액:" + account.getBalance());

    }
}
