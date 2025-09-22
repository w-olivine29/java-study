package day5.ex3;

public class BankMain {
    public static void main(String[] args) {
        // 1. 계좌 생성
        NormalAccount normal = new NormalAccount("1111-2222", "홍길동");
        // 마이너스 통장 개설 (한도 10만원)
        MinusAccount minus = new MinusAccount("3333-4444", "김철수", 100000);

        // 2. 입금
        normal.deposit(50000);
        minus.deposit(50000);

        System.out.println("==== 일반 계좌 출금 ====");
        System.out.println("현재 잔액 : " + normal.getBalance());
        // 7만원 출금 시도
        if (normal.withdraw(70000)) {
            System.out.println("출금 성공!");
        } else {
            System.out.println("출금 실패!");
        }

        System.out.println("==== 마이너스 계좌 출금 ====");
        System.out.println("현재 잔액 : " + minus.getBalance());
        // 7만원 출금 시도
        if (minus.withdraw(70000)) {
            System.out.println("출금 성공");
            System.out.println("현재 잔액 : " + minus.getBalance());
        } else {
            System.out.println("출금 실패");
        }
    }
}
