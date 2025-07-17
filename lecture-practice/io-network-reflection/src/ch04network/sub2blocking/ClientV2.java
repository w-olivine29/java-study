package ch04network.sub2blocking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static ch04network.utils.MyLogger.log;


//코드분석 추가설명은 pdf 참고 (필수)
public class ClientV2 {
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

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("전송 문자: ");
            String toSend = scanner.nextLine();

            // 서버에게 문자 보내기
            outputStream.writeUTF(toSend);
            log("client -> server: " + toSend);

            if(toSend.equals("exit")){
                break;
            }

            // 서버로부터 문자 받기
            String received = inputStream.readUTF();
            log("client <- server: " + received);
        }


        // 자원 정리 (현 예제에서는 간략하게)
        log("연결 종료: " + socket);
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}

/*
현재 Client를 여러개 실행했을 때, 모두 소켓은 만들어지지만,
실제로 서버와 정상적으로 데이터를 주고 받는 클라이언트는 맨 처음 실행한 Client 뿐인 상황이다.
(클라이언트1, 클라이언트2 를 연결했다고 가정)

    
1. 클라이언트와 서버의 TCP 3way handshake 완료
    -> 클라이언트의 소켓 객체 정상 생성 (이 시점에는 서버의 소켓객체 생성x, (서버소켓을 의미x))
    -> 서버 OS 에서는 OS backlog queue 에 연결 정보 보관
        클라이언트1 과 클라이언트2의 TCP 연결정보 모두 들어가있음

2. 서버와 클라이언트가 데이터를 주고 받으려면, 서버도 소켓 객체를 획득해야함
    -> ServerSocket accept() 호출
        OS backlog queue 에 있는 연결 정보 하나를 꺼내서, 해당 정보를 기반으로 Socket 생성
            새로만들어진 Socket 의 기반이 됐던 TCP 정보에 있는 클라이언트는 "소켓의 스트림"을 통해 서버와 데이터를 주고 받을 수 있음
            (해당 클라이언트는 클라이언트1 이라고 가정)

    클라이언트2
    backlog queue 에 아직 남아있는 연결정보의 클라이언트는 서버와 데이터를 주고 받을 수 없음
    (하지만 서버 OS와 TCP 연결은 됐기 때문에 서버 OS 측에 메세지를 보낼 수는 있음, 하지만 서버 애플리케이션은 모르는 것임)
-----

클라이언트가 메세지를 서버에 전송하는 경우
- 클라이언트
    - 애플리케이션 -> OS TCP 송신 버퍼 -> 클라이언트 네트워크 카드 (컴퓨터가 네트워크에 연결되기 위한 하드웨어 장치)

- 클라이언트가 보낸 메시지가 서버에 도착했을 때 (서버)
    - 서버 네트워크 카드 -> OS TCP 수신 버퍼 -> 애플리케이션
    (애플리케이션에서 소켓의 InputStream을 통해 TCP 수신버퍼에 있는 메시지를 읽는 것임)


실생활로 비유하자면)
- 애플리케이션 -> OS TCP 송신 버퍼
    내가 우편함에 편지를 넣는다.
- OS TCP 송신 버퍼 -> 클라이언트 네트워크 카드
    우편함에 쌓인 편지를 집배원이 수거해서 우체국에 가져간다
- 서버 네트워크 카드 -> OS TCP 수신 버퍼
    우체국에서 목적지의 우편함에 편지를 배송
- OS TCP 수신 버퍼 -> 애플리케이션
    편지 주인이 우편함에서 편지를 꺼낸다 (도착)

프로그래머 = 편지 쓰는 사람
우편함 = TCP 버퍼 (임시 저장소)
우체국 = 네트워크 카드 (실제 전송 담당)
편지 확인 = InputStream 읽기


서버 애플리케이션 측에서 클라이언트2와 연결된 소켓이 없어도, 서버 OS는 TCP IP 연결은 이미 돼있는 상태이기때문에,
클라이언트2 에서 데이터를 보내면, 서버의 OS 에서 데이터를 받아준다. -> 서버의 OS TCP 수신 버퍼에서 대기

서버 애플리케이션에서는 inputStream 으로
 OS TCP 수신 버퍼에 있는 데이터를 가지고 와야 클라이언트가 보낸 데이터를 읽을 수 있음
 결론은 "소켓 객체가 있어야 스트림을 사용하여" 데이터 주고받을 수 있음

클라이언트2 가 보낸 메세지는 서버 애플리케이션에서 읽지 못하고, 계속 OS TCP 수신 버퍼에서 대기 상태이다.

*/

