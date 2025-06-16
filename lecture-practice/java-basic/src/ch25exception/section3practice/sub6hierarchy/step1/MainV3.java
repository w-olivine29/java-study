package ch25exception.section3practice.sub6hierarchy.step1;

import ch25exception.section3practice.sub6hierarchy.step1.exception.*;

import java.util.Scanner;

public class MainV3 {
    public static void main(String[] args) throws NetworkClientExceptionV3 {
        NetworkServiceV3_1 networkService = new NetworkServiceV3_1();

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
