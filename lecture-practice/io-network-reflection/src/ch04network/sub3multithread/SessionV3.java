package ch04network.sub3multithread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;

// 버전을 클라이언트, 서버 버전에 맞춰놓음
public class SessionV3 implements Runnable {
    private final Socket socket; // 서버 쪽에서 accept() 완료 후 받은 소켓객체

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

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

            // 클라이언트 연결을 직접 종료하면 예외발생 -> 자원정리 코드 호출 불가한 상태
            // 자바 객체는 GC의 대상이지만, 자바 외부의 자원은 자동으로 정리되지 않기때문에 꼭 정리를 해야함
            log("연결 종료: " + socket);
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
