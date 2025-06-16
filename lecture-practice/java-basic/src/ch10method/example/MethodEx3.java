package ch10method.example;

import java.util.Scanner;

// 입출금
public class MethodEx3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int balance = 0;

        while (true) {
            System.out.println("==== [1]입금  [2]출금 [3]현재잔액 [4]종료 ====");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 4) {
                System.out.println("종료");
                break;
            }

            // 결과 금액을 갱신
            balance = switch (option) {

                case 1 -> {
                    System.out.print("입금하실 금액을 입력: ");
                    yield deposit(balance, scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("[현재잔액:" + balance + "원] 출금하실 금액을 입력: ");
                    yield withdraw(balance, scanner.nextInt());
                }
                case 3 -> {
                    System.out.println("현재잔액: " + balance);
                    yield balance;
                }
                default -> {
                    System.out.println("옵션을 다시 선택해주세요.");
                    yield balance;
                }
            };
        }
    }

    //입금
    static int deposit(int balance, int depositAmount) {

        return balance + depositAmount;
    }

    //출금
    static int withdraw(int balance, int withdrawAmount) {

        if (withdrawAmount <= 0) {
            System.out.println("잘못된 입력");
            return balance;
        }
        if (balance < withdrawAmount) {
            System.out.println("잔액부족 출금불가");
            return balance;
        }

        return balance - withdrawAmount;

    }

}
