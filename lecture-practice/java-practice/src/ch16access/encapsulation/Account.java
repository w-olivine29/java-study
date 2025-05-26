package ch16access.encapsulation;

/* 캡슐화)
 * 속성과 기능을 하나로 묶고, 외부에 필요한 기능만 노출하고 나머지는 모두 내부로 숨기는 것
 * */
public class Account {

    // private 이 아니면 캡슐화가 깨져버린다.
    private long balance;

    // 외부제공 기능
    public void deposit(long amount) {

        isAmountValid(amount);
        balance += amount;
    }

    // 외부제공 기능
    public void withdraw(long amount) {

        if (isAmountValid(amount) && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다.");
        }
    }

    // 외부제공 기능
    public long getBalance() {
        return balance;
    }

    /*내부기능으로 만드는 이유
    ex) 해당기능을 public로 해버리면,
        deposit, withdraw에 인수를 넘기기 전에, 이 메서드로 내가 직접 검증을 거친 뒤 넘겨야하나..?
    */
    private boolean isAmountValid(long amount) {
        return amount > 0;
    }

}
