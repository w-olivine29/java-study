package ch04network.sub1start;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;


//코드분석 추가설명은 pdf 참고 (필수)
public class ServerV1 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");

        // 서버는 클라이언트 연결을 받기 위한 특별한 소켓이 필요
        // ServerSocket은 지정된 포트에서 클라이언트 연결 요청을 대기하는 역할
        // 서버 소켓은 클라이언트가 서버에 접속(TCP 3-way handshake)하는 것까지만 처리
        // 완료된 연결들을 backlog queue에 담아두고, accept() 호출 시 하나씩 반환
        ServerSocket serverSocket = new ServerSocket(PORT); // 해당 코드 실행 시 시스템 콜을 통해 포트를 바인딩하고 LISTEN 상태로 변경
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // 서버가 올라가고 LISTEN 상태로 대기 (클라이언트 연결 요청을 기다림) (해당 주소의 포트에 누군가가 접속하기 전까지)

/*       "accept() 호출 시 OS backlog queue 에서 TCP 연결 정보 조회"
            - 만약 TCP 연결 정보가 없다면, 연결 정보가 생성될 때까지 대기 (블로킹)

         대기중 해당 포트에 누군가 접속하면, TCP 3-way handshake를 수행하여 연결을 수립
          -> 연결 성공 시  OS backlog queue 에 연결 정보를 보관

         TCP 연결정보를 기반으로 서버에 새로운 Socket 생성 
            - Socket을 통해서 클라이언트와 서버가 통신할 수 있게 됨
            - 사용한 TCP 연결정보는 backlog queue 에서 제거
      
         ServerSocket: 연결 요청 대기용, Socket: 실제 통신용
         
         통신할 때는 클라이언트도 Socket을 가지고 있고, 서버도 Socket을 가지고 있음
         이 두 Socket은 TCP로 연결돼있으며, 스트림을 통해 데이터를 주고 받을 수 있음
         */
        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        // 이 예제에서는 클라이언트가 먼저 메시지를 보내는 프로토콜을 사용
        // 클라이언트로부터 문자 받기 (블로킹 메서드)
        String received = inputStream.readUTF();
        log("client -> server: " + received);

        // 클라이언트에게 문자 보내기
        String toSend = received + "World!";
        outputStream.writeUTF(toSend);
        log("client <- server: " + toSend);


        // 자원 정리 (역순으로 정리하는 것이 일반적)
        // 주의: ServerSocket은 정리하지 않음 (여러 클라이언트를 받을 수 있도록)
        // 하지만 이 예제는 단일 클라이언트만 처리하므로 serverSocket.close()도 추가하는 것이 좋음
        // 현 예제에서는 자원정리 간략화
        log("연결 종료: " + socket);
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}


/*
    53.825 [     main] 서버 시작
    53.827 [     main] 서버 소켓 시작 - 리스닝 포트: 12345
    59.993 [     main] 소켓 연결: Socket[addr=/127.0.0.1,port=51212,localport=12345]
    59.994 [     main] client -> server: Hello
    59.994 [     main] client <- server: HelloWorld!
    59.994 [     main] 연결 종료: Socket[addr=/127.0.0.1,port=51212,localport=12345]


next step) 
    메세지를 계속 주고 받고, 원할 때 종료할 수 있도록 변경
*/
