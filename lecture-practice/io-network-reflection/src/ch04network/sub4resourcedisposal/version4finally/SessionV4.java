package ch04network.sub4resourcedisposal.version4finally;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;
import static utils.SocketClose.closeAll;

// 버전을 클라이언트, 서버 버전에 맞춰놓음
public class SessionV4 implements Runnable {
    private final Socket socket; // 서버 쪽에서 accept() 완료 후 받은 소켓객체

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;

        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

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
        } finally {
            closeAll(socket, inputStream, outputStream);
            log("연결 종료: " + socket);
        }
    }
}
