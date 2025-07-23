package ch06http.was.v3addfunction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.MyLogger.log;

public class HttpServerV3 {

    // 현 실습에서는 10개의 요청을 동시처리 할 수 있게끔 하였음
    private final ExecutorService es = Executors.newFixedThreadPool(10);
    private final int port;

    public HttpServerV3(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        // 현재 버전은 동시요청 불가 (순차적으로 요청 처리 - 거의 동시에 두 곳에서 요청 시 차순위로 밀린 곳은 10초 걸림)
        while (true) {
            Socket socket = serverSocket.accept(); // OS backlog에 있는 웹브라우저 연결 정보로 소켓 생성
            es.submit(new HttpRequestHandlerV3(socket));
        }
    }

}