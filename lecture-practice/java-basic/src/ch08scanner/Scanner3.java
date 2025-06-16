package ch08scanner;

import java.util.Scanner;

/**
 * 두 개의 수를 입력 받고 더 큰수를 출력
 * 같은 경우는 같다고 출력
 */
public class Scanner3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1;
        double num2;

        System.out.print("첫 번째 수를 입력하시오: ");
        num1 = scanner.nextDouble();

        System.out.print("두 번째 수를 입력하시오: ");
        num2 = scanner.nextDouble();

        if (num1 == num2) {
            System.out.println("두 수의 크기는 같습니다. " + num1);
        } else {
            System.out.println("더 큰 수는 " + Math.max(num1, num2) + "입니다.");
        }

        scanner.close();

    }
}
