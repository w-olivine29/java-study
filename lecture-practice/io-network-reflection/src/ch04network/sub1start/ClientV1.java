package ch04network.sub1start;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ch04network.utils.MyLogger.log;

// 내 컴퓨터안에서 서로 TCP IP 통신 실습
//코드분석 추가설명은 pdf 참고 (필수)
public class ClientV1 {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        // 네트워크에 연결하려면 자바에서는 소켓이라는 객체 필요
        // 해당 주소의 포트에 연결시도 (TCP 3-way handshake 수행)
        // 클라이언트의 포트를 따로 지정하지 않는 상태 -> 자동 랜덤 할당 (클라이언트는 보통 포트를 생략)
        // localhost 가 안된다면, 자신의 PC 운영체제에 localhost가 127.0.0.1로 매핑돼있지 않은 상태 (이 떄는 직접 127.0.0.1 입력)
        Socket socket = new Socket("localhost", PORT); // Connection refused: connect 해당 포트에 서버가 올라가지 있지 않다면 예외발생


        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        log("소켓 연결:" + socket);

        // 서버에게 문자 보내기
        String toSend = "Hello";
        outputStream.writeUTF(toSend);
        log("client -> server: " + toSend);

        // 서버로부터 문자 받기
        String received = inputStream.readUTF();
        log("client <- server: " + received);

        // 자원 정리 (현 예제에서는 간략하게)
        log("연결 종료: " + socket);
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}

/*
    59.980 [     main] 클라이언트 시작
    59.993 [     main] 소켓 연결:Socket[addr=localhost/127.0.0.1,port=12345,localport=51212]
    59.993 [     main] client -> server: Hello
    59.994 [     main] client <- server: HelloWorld!
    59.995 [     main] 연결 종료: Socket[addr=localhost/127.0.0.1,port=12345,localport=51212]
    

Socket[addr=localhost/127.0.0.1,port=12345,localport=51212]    
    - 127.0.0.1 은 localhost (내 컴퓨터) 를 뜻함
        - IP 주소 체계에서 루프백 주소로 지정된 특별한 IP 주소
        - 컴퓨터가 스스로를 가리킬 때 사용
        - 컴퓨터가 네트워크 인터페이스를 통해 외부로 나가지 않고, 자신에게 직접 네트워크 패킷을 보낼 수 있도록 한다
    - 12345 포트에 접근하는 소켓
    - port: 연결대상 포트 (서버 포트) (12345)
    - localport: 현재 내 포트 (51212)


TCP 통신에서는 양쪽 모두 포트가 필요하다
클라이언트의 [IP:PORT] <-> 서버의 [IP:PORT]
예: 127.0.0.1:51212 <-> 127.0.0.1:12345


next step)
    메세지를 계속 주고 받고, 원할 때 종료할 수 있도록 변경
*/

