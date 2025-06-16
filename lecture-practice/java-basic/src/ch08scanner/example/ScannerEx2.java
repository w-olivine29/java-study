package ch08scanner.example;

import java.util.Scanner;

/**
 * 홀짝 판별
 * 하나의 정수를 입력받고 홀짝 판별
 */
public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하시오: ");
        int num = scanner.nextInt();

        String result = (num % 2 == 0) ? "짝수" : "홀수";
        System.out.println("입력하신 숫자는 " + result + "입니다.");

        scanner.close();
    }
}
