package ch05chatprogram.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static ch05chatprogram.utils.MyLogger.log;

public class WriteHandler implements Runnable {

    private static final String DELIMITER = "\\|"; // 정규표현식에서 |는 or연산자이기때문에 리터럴 문자로 인식하게끔 이스케이프 문자 사용
    private final DataOutputStream outputStream;
    private final Client client;
    private boolean closed;

    public WriteHandler(DataOutputStream outputStream, Client client) {
        this.outputStream = outputStream;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            String nickname = inputUsername(scanner);
            outputStream.writeUTF("/join" + DELIMITER + nickname);

            while (true) {
                String toSend = scanner.nextLine();  //블로킹 (사용자가 입력하지 않으면 해당 스레드가 무한 대기 -> 빠져나오려면 System.in.close())

                // 개행문자만 입력했다면 넘기기
                if (toSend.isEmpty()) {
                    continue;
                }
                // 채팅방 접속 종료
                if (toSend.equals("/exit")) {
                    outputStream.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하지않으면 일반 메세지
                if (toSend.startsWith("/")) {
                    outputStream.writeUTF(toSend); // 잘못된 명령어에 대한 여부는 서버에서 판단
                } else {
                    outputStream.writeUTF("/message" + DELIMITER + toSend);
                }

            }

        } catch (IOException | NoSuchElementException e) {
            log(e);

            // NoSuchElementException (Scanner를 닫은 상태에서 read 하면 발생)
        } finally {
            client.close(); // 전체 자원 정리
        }

    }

    private static String inputUsername(Scanner scanner) {
        System.out.print("닉네임을  입력하세요: ");
        String username;

        // 닉네임이 빈 값을 넘겼을 경우 다시 입력받기
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    // 나 자신 닫기
    // 다른 이유로도 호출 되는 상황이 있기때문에 동기화 처리
    public synchronized void close() {

        // close 가 두번 호출 되지 않도록 flag 조건문
        if (closed) {
            return;
        }

        try {
            System.in.close(); // Scanner 닫기 (사용자 입력 중지)
        } catch (IOException e) {
            log(e);
        }

        // 복잡한 종료 로직이 있다고 가정?
        closed = true;
        log("writeHandler 종료");

    }
}
