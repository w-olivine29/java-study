package ch04network.sub5execption.section2close.step1normal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;

public class NormalCloseServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept(); // 여기서 3-Way Handshake 발생 (syn + ack 단계)
        log("소켓 연결: " + socket);

        Thread.sleep(1000);
        socket.close(); // 클라이언트에게 FIN 패킷 보내기 (여기서 4-Way Handshake 시작)
        log("소켓 종료");

    }
}
