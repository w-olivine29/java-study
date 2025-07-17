package ch04network.sub2blocking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static ch04network.utils.MyLogger.log;


// 코드분석 추가설명은 pdf 참고 (필수)
// ServerV1 과 함께 참고
public class ServerV2 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");

        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        //accept() 는 이미 연결된 TCP 연결 정보를 기반으로 서버 측에 소켓 객체 생성
        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String received = inputStream.readUTF();
            log("client -> server: " + received);

            if (received.equals("exit")) {
                break;
            }

            // 클라이언트에게 문자 보내기
            String toSend = received + "World!";
            outputStream.writeUTF(toSend);
            log("client <- server: " + toSend);
        }


        // 자원 정리 (역순으로 정리하는 것이 일반적)
        // 주의: ServerSocket은 정리하지 않음 (여러 클라이언트를 받을 수 있도록)
        // 하지만 이 예제는 단일 클라이언트만 처리하므로 serverSocket.close()도 추가하는 것이 좋음
        // 현 예제에서는 자원정리 간략화
        log("연결 종료: " + socket);
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}


/*
현재 Client2를 여러개 실행했을 떄, 모두 소켓은 만들어지지만,
실제로 서버와 정상적으로 데이터를 주고 받는 클라이언트는 맨 처음 실행한 Client2 뿐이다.

ServerV2 에 둘 이상의 클라이언트가 작동하지 않는 이유)

    accept() 를 호출해야, 소켓 객체를 생성하고, 클라이언트와 소켓을 통해 메시지를 주고 받을 수 있는데,
    새로운 클라이언트가 접속 시 서버의 main 스레드는 accept() 메서드를 호출 할 수 없는 상태,
    while 문으로 기존 클라이언트와 메시지를 주고 받는 부분만 반복 중

    결국 별도의 스레드 필요
    - accept(): 클라이언트와 서버의 연결을 처리하기 위해 대기
    - readXxx(): 클라이언트의 메시지를 받아서 처리하기 위해 대기
    각각의 블로킹 작업은 별도의 스레드에서 처리해야함 (다른 블로킹 메서드 때문에 계속 대기할 수는 없음)
*/
