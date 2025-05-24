package ch13oop.example.ex2;

/*
잔액
입금, 출금, 현재잔액
* */
public class Account {
    int balance;

    void deposit(int amount) {

        System.out.println("입금금액: " + amount);
        balance += amount;
        printBalance();
    }

    void withdraw(int amount) {
        System.out.println("출금금액: " + amount);
        if (balance < amount) {
            System.out.println("잔액부족");
        } else {
            balance -= amount;
        }

        printBalance();
    }

    void printBalance() {
        System.out.println("현재잔액: " + balance);
        System.out.println("====================");
    }
}
