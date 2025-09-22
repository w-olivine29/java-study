package day11;

import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NumberInputHandler.execute(scanner);
        scanner.close();
    }
}

class NumberInputHandler {

    static void execute(Scanner scanner) {
        System.out.println("숫자를 입력하시오. (종료: exit)");

        while (true) {
            System.out.print("입력: ");
            String input = scanner.nextLine().strip();

            if (input.equals("exit")) {
                System.out.println("프로그램 종료");
                return;
            }

            try {
                int number = Integer.parseInt(input);
                System.out.printf("숫자 변환 성공: (%d)\n", number);
            } catch (NumberFormatException e) {
                System.out.println("입력한 값이 숫자가 아닙니다.");
                System.out.println(e);
            }
        }

    }

}
