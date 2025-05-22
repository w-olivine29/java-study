package ch08scanner;

import java.util.Scanner;

/**
 * 두 수를 입력받아 그 합을 출력
 */
public class Scanner2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1;
        double num2;

        System.out.print("첫 번째 숫자를 입력하시오: ");
        num1 = scanner.nextDouble();

        System.out.print("두 번째 숫자를 입력하시오: ");
        num2 = scanner.nextDouble();

        System.out.println("두 수의 합: " + (num1 + num2));

        scanner.close();
    }
}
