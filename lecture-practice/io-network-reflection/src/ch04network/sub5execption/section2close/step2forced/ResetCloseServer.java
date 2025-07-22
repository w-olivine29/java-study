package ch04network.sub5execption.section2close.step2forced;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;

public class ResetCloseServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소켓 연결:" + socket);

        // 연결하자마자 FIN 보내기
        socket.close();
        serverSocket.close();
    }
}
