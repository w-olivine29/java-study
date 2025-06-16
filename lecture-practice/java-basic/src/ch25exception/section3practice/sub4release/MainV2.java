package ch25exception.section3practice.sub4release;

import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) throws NetworkClientExceptionV2 {
        NetworkServiceV2_4 networkService = new NetworkServiceV2_4();

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
