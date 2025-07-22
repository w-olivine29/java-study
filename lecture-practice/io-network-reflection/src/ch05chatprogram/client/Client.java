package ch05chatprogram.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;
import static utils.SocketClose.closeAll;


// 기존에 실습했던 것과 달리 조금 더 객체지향적으로 설계
// 클라이언트 전반을 관리하는 클래스
// 필요한 모든 요소들을 생성 & 관리 (Socket, Read 관련, Write 관련)
public class Client {

    private final String host;
    private final int port;

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;
    private boolean closed;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("클라이언트 시작");
        socket = new Socket(host, port);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());

        readHandler = new ReadHandler(inputStream, this);
        writeHandler = new WriteHandler(outputStream, this);

        Thread readThread = new Thread(readHandler, "readHandler");
        Thread wirteThread = new Thread(writeHandler, "writeHandler");

        readThread.start();
        wirteThread.start();
    }

    // 여러 스레드에서 동시 호출될 가능성이 있음
    public synchronized void close() {

        if (closed) {
            return;
        }
        writeHandler.close();
        readHandler.close();
        closeAll(socket, inputStream, outputStream);

        closed = true;
        log("연결 종료: " + socket);
    }
}
