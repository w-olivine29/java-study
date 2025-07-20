package ch04network.sub5execption.connect.step2timeout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTimeoutServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        Thread.sleep(100000000); // 무한 대기 시나리오
    }
}
