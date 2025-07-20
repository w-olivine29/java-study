package ch04network.sub5execption.section2close.step1normal;

import java.io.*;
import java.net.Socket;

import static ch04network.utils.MyLogger.log;

public class NormalCloseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream inputStream = socket.getInputStream();

        readByInputStream(inputStream, socket);
//        readByBufferedReader(inputStream, socket);
//        readByDataInputStream(inputStream, socket);

        log("연결 종료: " + socket.isClosed());
    }

    private static void readByInputStream(InputStream inputStream, Socket socket) throws IOException {

        int read = inputStream.read(); // 서버가 FIN 보냈으므로 -1 반환
        log("read = " + read);

        // 서버에서 연결을 끊으면, 나에게 FIN 패킷을 보낸 것이고, end of file 를 받게되는 것
        if (read == -1) { // EOF 감지
            inputStream.close();
            socket.close();  // 클라이언트도 FIN 전송
        }
    }

    private static void readByBufferedReader(InputStream inputStream, Socket socket) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String readString = br.readLine();  // 서버 FIN으로 인해 null 반환
        log("readString = " + readString);

        if (readString == null) { // EOF 감지
            br.close();
            inputStream.close();
            socket.close(); // 클라이언트도 FIN 전송
        }
    }

    private static void readByDataInputStream(InputStream inputStream, Socket socket) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        try {
            dataInputStream.readUTF(); // 서버 FIN으로 인해 EOFException 발생
        } catch (EOFException e) {
            log(e);  // EOF 예외 처리
        }finally {
            dataInputStream.close();
            inputStream.close();
            socket.close();  // 클라이언트도 FIN 전송
        }

    }
}
/*
TCP IP 에서 연결을 정상 종료하려면 둘 다 PIN 패킷을 주고 받아야한다.

4-Way Handshake (FIN → ACK → FIN → ACK)

1. A→B: FIN (A가 종료 요청)
2. B→A: ACK (B가 확인, 하지만 아직 남은 작업이 있을 수 있음)
3. B→A: FIN (B도 모든 작업 완료 후 종료 요청)
4. A→B: ACK (A가 최종 확인)

1. 서버가 연결 종료 시작 (애플리케이션이 종료 요청)
    socket.close()
    -> 서버 OS → 클라이언트 OS: FIN 패킷 전송 (OS)

2. 클라이언트 자동 응답
    클라이언트 OS → 서버 OS: ACK 패킷 전송 (OS - 자동)

3. 클라이언트(애플리케이션)가 EOF 감지 후 종료
    if문으로 EOF 감지 후 close();
      -> 클라이언트 OS → 서버 OS: FIN 패킷 전송 (OS)

4. 서버 자동 응답
    서버 OS → 클라이언트 OS: ACK 패킷 전송 (OS - 자동)


OS 레벨: ACK는 즉시 자동 응답
애플리케이션 레벨: read() 계열 메서드를 호출해야만 EOF를 감지

클라이언트 애플리케이션은 실제로 읽기를 시도할 때까지 연결 종료를 모름
*/

/*
next step)
    상대방에서 FIN 메세지를 받았는데,
    내 쪽에서 FIN 을 무시하고, 계속 메세지를 보내겠다 라면?
*/