package ch08scanner.example;

import java.util.Scanner;

/* 구구단
하나의 정수 n 입력받고, n의 구구단 출력
* */
public class ScannerEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하시오. ");
        int num = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\n", num, i, (num * i));
        }
        scanner.close();
    }
}
