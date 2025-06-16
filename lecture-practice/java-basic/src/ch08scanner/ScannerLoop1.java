package ch08scanner;

import java.util.Scanner;

/**
 * 메아리
 * 사용자가 입력한 문자열을 그대로 출력
 * exit 라는 문자 입력시 프로그램 종료 (그 전까지는 반복실행)
 */
public class ScannerLoop1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputStr = "";

        System.out.println("시작");
        while (true) {
            inputStr = scanner.nextLine();
            if ("exit".equals(inputStr)) {
                System.out.println("종료");
                scanner.close();

                break;
            }
            System.out.println(inputStr + "~~~");
        }


    }


}
