package ch04network.sub5execption.section2close.step2forced;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static utils.MyLogger.log;

public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        //client <- server FIN
        Thread.sleep(1000); // 서버에서 close() 할 때까지 잠시 대기

        // client -> server: PUSH[1]
        // FIN 을 받았지만, 무시하고 메세지 보내기 (TCP IP 규약에 위배 - 상대방이 FIN을 보내면 이쪽에서도 FIN을 보내야함)
        outputStream.write(1);

        // client <- server: RST
        // 지금 이 연결은 잘못됐고, 강제적으로 끊으라는 의미
        Thread.sleep(1000); //RST 받을 때까지 잠시 대기

        try {
            int read = inputStream.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
            // SocketException: 현재 연결은 사용자의 호스트 시스템의 소프트웨어의 의해 중단되었습니다
            // SocketException: Connection reset
        }


        // RST를 받았는데 무시하고 또 데이터를 보내기 시도
        try {
            outputStream.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
            // SocketException: 현재 연결은 사용자의 호스트 시스템의 소프트웨어의 의해 중단되었습니다
            // SocketException: Broken pipe
        }

    }
}
/*
1. 서버는 종료를 위해 socket.close() 호출
    -> 서버는 클라이언트에게 FIN 패킷 전달

2. 클라이언트는 output.write() 를 통해 서버에 메시지 전달
    -> 데이터를 전송하는 PUSH 패킷을 서버에 전달
    -> 그러나 서버가 기대하는 값은 FIN 패킷

3. 서버는 TCP 연결에 문제가 있다고 판단
    -> 즉각 연결 종료하라는 RST 패킷을 클라이언트에 전송
    
RST 패킷이 도착했다는 것은 현재 TCP 연결에 심각한 문제가 있으므로, 해당 연결을 더는 사용하면 안된다는 의미
-> RST 패킷이 도착했는데, FIN 패킷을 보내주지 않고, 수신, 송신등의 요청을 하면 예외 발생

RST(Reset)
- TCP 에서 RST 패킷은 연결 상태를 초기화(리셋) 해서 더 이상 현재의 연결을 유지하지 않겠다는 의미 전달
    Reset은 현재 세션을 강제 종료하고 연결을 무료화하라는 뜻
    
발생상황 예시)
    - TCP 스펙에 맞지 않는 순서로 메세지가 전달될 때
    - TCP 버퍼에 있는 데이터를 아직 다 읽지 않았는데, 연결을 종료할 때
    - 방화벽 같은 곳에서 연결을 강제로 종료할 때도 발생
*/
