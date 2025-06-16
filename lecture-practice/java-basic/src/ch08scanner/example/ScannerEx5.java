package ch08scanner.example;

import java.util.Scanner;

/* 사이 숫자
두 개의 정수를 입력 받고, 두 정수 사이의 모든 정수 출력
ex) 5,2 -> 2,3,4,5
 * */
public class ScannerEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();


        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int i = num1; i <= num2; i++)
            if (i < num2) {
                System.out.print(i + ",");
            } else {
                System.out.print(i);
            }
    }
}
