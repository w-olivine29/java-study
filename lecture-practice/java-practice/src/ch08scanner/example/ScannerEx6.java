package ch08scanner.example;

import java.util.Scanner;

/*이름, 나이 입력받고 출력 (반복)
 * 출력 형태: "당신의 이름은 [이름]이고, 나이는 [나이]살 입니다."
 * 종료 입력시 종료
 * */
public class ScannerEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = 0;
        while (true) {
            System.out.println("\n\n(종료 입력시 종료)");
            System.out.print("이름: ");
            String name = scanner.nextLine();

            if ("종료".equals(name)) {
                scanner.close();
                break;
            }

            System.out.print("나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.printf("%d. 이름: [%s], 나이: [%d]", ++cnt, name, age);
        }
    }
}
