package ch08scanner;

import java.util.Scanner;

/* 합계를 계산 (반복)
0입력시 종료
* */
public class ScannerLoop3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        while (true) {
            System.out.print("더할 숫자를 입력하시오 (0 입력시 종료): ");
            double num = scanner.nextDouble();
            if (num == 0) {
                System.out.println("총 합계: " + sum);
                break;
            }
            sum += num;
        }
    }
}
