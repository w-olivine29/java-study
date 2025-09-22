package day4;

// 입금, 출금, 잔액조회 기능을 가지고 있는 은행 계좌 클래스 만들어보기
public class BankAccount {

    public static void main(String[] args) {
        // 계좌생성
        BankAccount account1 = new BankAccount("211-xxxxxx-xxxxx", "고객1");
        BankAccount account2 = new BankAccount("211-xxxxxx-xxxxx", "고객2");

        // 입급 테스트
        account1.deposit(10000);
        System.out.printf("%s 님의 잔액: %d 원\n", account1.getOwner(), account1.getBalance());


        // 출금 테스트
        System.out.printf("%s 님의 계좌 출금 금액: %d -> 결과: %b\n",
                account1.getOwner(), 5000, account1.withdraw(5000));;

        System.out.printf("%s 님의 잔액: %d 원\n", account1.getOwner(), account1.getBalance());


        // 잔액 부족 테스트
        System.out.printf("\n%s 님의 계좌 출금 금액: %d -> 결과: %b\n",
                account1.getOwner(), 5100, account1.withdraw(5100));;

        System.out.printf("%s 님의 잔액: %d 원\n", account1.getOwner(), account1.getBalance());


        // 전체 계좌 수 확인
        System.out.println("전체 계좌수: " + BankAccount.getTotalAccounts());
    }

    private static int totalAccounts; // BankAccount 자체에서 공유되는 변수

    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        balance = 0;

        totalAccounts++;
    }

    // 입급
    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    // 출금
    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // 잔액 조회
    public int getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }
}
