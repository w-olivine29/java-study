package ch08scanner.example;

import java.util.Scanner;

/*이름, 나이 입력받고 출력
 * 출력 형태: "당신의 이름은 [이름]이고, 나이는 [나이]살 입니다."
 * */
public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하시오: ");
        String name = scanner.nextLine();

        System.out.print("나이를 입력하시오: ");
        int age = scanner.nextInt();

        System.out.printf("당신의 이름은 [%s]이고, 나이는 [%d]살 입니다.", name, age);
        scanner.close();
    }
}
