package ch08scanner.example;

import java.util.Scanner;

/* 입력한 숫자의 합계와 평균
 * */
public class ScannerEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = 0;
        int sum = 0;
        double average = 0;

        while (true) {

            System.out.println("[0을 입력 시 종료]");
            System.out.print("정수를 입력하시오. ");
            int num = scanner.nextInt();

            if (num == 0) {
                scanner.close();
                break;
            }
            cnt++;
            sum += num;
        }

        average = (double) sum / cnt;
        System.out.printf("총 합계: %d, 평균: %.1f", sum, average);
    }
}
