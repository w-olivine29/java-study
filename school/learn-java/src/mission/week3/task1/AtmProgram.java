package mission.week3.task1;

import java.util.InputMismatchException;
import java.util.Scanner;


public class AtmProgram {

    public static void main(String[] args) {
        AtmProgram atm = new AtmProgram(new Account(1000));
        atm.execute();
    }

    private final Scanner scanner;
    private final Account account;

    public AtmProgram(Account account) {
        this.scanner = new Scanner(System.in);
        this.account = account;
    }

    private void execute() {

        try {
            while (true) {
                System.out.println("출금: withdraw | 프로그램 종료: exit");

                switch (scanner.nextLine()) {
                    case "withdraw" -> {
                        withdrawProcess();
                        return;
                    }
                    case "exit" -> {
                        return;
                    }
                    default -> System.out.println("명령어를 다시 입력해주세요.");
                }
            }
        } catch (AccountTransactionException e) {
            System.out.printf("%s (%s)\n",
                    e.getMessage(),
                    (e.getCause() == null) ? "" : e.getCause());

        } catch (Exception e) {
            System.out.println("예상치 못한 예외 발생");
            System.out.println(e.getCause().getMessage());
        } finally {
            System.out.println("거래 기록이 저장되었습니다.");
            scanner.close();
        }
    }

    private void withdrawProcess() {
        System.out.print("출금할 금액 입력: ");

        try {
            long inputAmount = scanner.nextLong(); //예외발생 가능
            account.withdraw(inputAmount); //예외발생 가능

        } catch (InputMismatchException e) {
            throw new AccountTransactionException("올바른 숫자를 입력해주세요.", e);
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
}


class Account {

    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }


    public void withdraw(long amount) {
        if (balance < amount) {
            throw new AccountTransactionException("잔액 부족");
        }

        balance -= amount;
        System.out.println("출금 완료! 남은 잔액: " + balance);
    }
}

class AccountTransactionException extends RuntimeException {

    public AccountTransactionException(String message) {
        super(message);
    }

    public AccountTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}