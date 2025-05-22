package ch08scanner;

import java.util.Scanner;

/* 입력받은 두 수를 더해서 출력 (반복)
 * 모두 0을 입력 시 종료
 * */
public class ScannerLoop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        while (true) {
            System.out.println("=== 두 수를 입력하시오 ===");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();

            if (num1 == 0 && num2 == 0) {
                System.out.println("종료");
                break;
            }
            System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, (num1 + num2));
        }
    }
}
