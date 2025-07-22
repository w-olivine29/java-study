package ch04network.sub3multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;


//코드분석 추가설명은 pdf 참고 (필수)
public class ServerV3 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        // main 스레드는 새로운 연결이 있을 때마다, Session 객체와 별도의 스레드 생성, 별도의 스레드가 Session 객체를 실행하도록 한다
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);


        // 반복
        while (true) {
            Socket socket = serverSocket.accept(); // 블로킹 (OS blocking queue에 연결정보가 들어오고, 소켓을 생성하기 까지)
            log("소켓 연결: " + socket);

            SessionV3 session = new SessionV3(socket);

            Thread thread = new Thread(session);
            thread.start();
        }


    }
}

