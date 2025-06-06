package ch25exception.section3practice.sub8trywithresources;

import ch25exception.section3practice.sub8trywithresources.exception.ConnectException;
import ch25exception.section3practice.sub8trywithresources.exception.NetworkClientExceptionV5;

import java.util.Scanner;


public class MainV5 {
    public static void main(String[] args) throws NetworkClientExceptionV5 {
        NetworkServiceV5 networkService = new NetworkServiceV5();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n전송 메세지 입력: ");
            String message = scanner.nextLine();

            if ("exit".equals(message)) {
                break;
            }

            // 한 곳에서 공통처리
            try {
                networkService.sendMessage(message);
            } catch (Exception e) {
                exceptionHandler(e);
            }

        }
        System.out.println("프로그램 종료");
        scanner.close();
    }

    //공통 예외처리
    private static void exceptionHandler(Exception e) {
        System.out.println("==== 사용자에게 메세지를 보낸다고 가정 ====");

        System.out.println("==== 개발자용 디버깅 메세지 (콘솔출력) ====");
        e.printStackTrace(System.err); // IDE에서 출력결과를 빨간색으로 보여줌
        //e.printStackTrace(System.out); // 표준 출력
        //e.printStackTrace();

        // 필요 시 예외별로 별도의 추가 처리 가능
        if (e instanceof ConnectException connectEx) {
            System.out.printf("[connect error] address: %s, message: %s \n",
                    connectEx.getAddress(), e.getMessage());
        }
    }
    /*
     * 개발자용 디버깅 메시지 출력
     *
     * - 실무에서는 System.out/err 대신 별도의 로깅 라이브러리 사용 권장
     * - printStackTrace는 콘솔에만 출력되므로, 서버 환경에서는 로그 확인이 어려움
     *   (서버에서는 일반적으로 로그 파일을 통해 확인함)
     * - 참고: printStackTrace(System.out)과 System.err를 동시에 사용할 경우 출력 순서가 보장되지 않음
     */
}
