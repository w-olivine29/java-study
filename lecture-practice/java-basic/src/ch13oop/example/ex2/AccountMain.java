package ch13oop.example.ex2;

/* 객체 지향 계좌
은향계좌를 객체로 설계

계좌 - 잔액, 입금, 출금
* */
public class AccountMain {
    public static void main(String[] args) {

        Account account = new Account();
        account.printBalance();

        account.withdraw(3000);
        account.deposit(100000);
        account.deposit(2000);
    }
}
