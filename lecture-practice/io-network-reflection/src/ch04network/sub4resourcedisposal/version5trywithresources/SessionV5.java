package ch04network.sub4resourcedisposal.version5trywithresources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;

// 버전을 클라이언트, 서버 버전에 맞춰놓음
public class SessionV5 implements Runnable {
    private final Socket socket; // 서버 쪽에서 accept() 완료 후 받은 소켓객체

    public SessionV5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (this.socket;
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());) {


            while (true) {

                // 메세지 수신
                String received = inputStream.readUTF();
                log("client -> server: " + received);

                if (received.equals("exit")) {
                    break;
                }

                // 메세지 송신
                String toSend = received + "World!";
                outputStream.writeUTF(toSend);
                log("client <- server: " + toSend);
            }

        } catch (IOException e) {
            log(e);
        }

        // 정말 AutoCloseable 이 호출돼서 소켓의 close() 가 호출됐는지 확인
        log(String.format("연결 종료: %s isClosed: + %b", socket, socket.isClosed()));
    }
}
