package ch25exception.section1necessity.step1start;

import java.util.Scanner;

public class MainV0 {
    public static void main(String[] args) {
        NetworkServiceV0 networkService = new NetworkServiceV0();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n전송 메세지 입력: ");
            String message = scanner.nextLine();

            if ("exit".equals(message)) {
                break;
            }
            networkService.sendMessage(message);
        }
        System.out.println("프로그램 종료");
        scanner.close();
    }
}
