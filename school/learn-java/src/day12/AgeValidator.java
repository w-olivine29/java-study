package day12;

import java.util.Scanner;

public class AgeValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("나이를 입력하세요. (종료: exit)");

        while (true) {
            System.out.print("입력: ");
            String input = scanner.nextLine().strip();

            if (input.equals("exit")) {
                System.out.println("프로그램 종료");
                break;
            }

            try {
                int age = Integer.parseInt(input);
                validateAge(age);
                System.out.println("유효한 나이입니다.");

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            } catch (InvalidAgeException e) {
                System.out.println("입력오류: " + e.getMessage());
            }
        }
    }

    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("허용나이: 0 ~ 120");
        }
    }
}

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
