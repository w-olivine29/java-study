package ch04network.sub5execption.connect.step2timeout;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

//네트워크 연결을 시도해서 서버 IP에 연결 패킷을 전달했으나 응답이 없는 경우
public class ConnectTimeoutMain2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket(); // 인수를 넘기는 다른 생성자는 객체 생성 시 바로 연결, 기본생성자는 연결 x
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 2000);
        } catch (SocketTimeoutException e) {
            e.printStackTrace(); // Connection timed out: connect
        }

        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start)); //end = 21050

    }
}
/*
사설 IP대역(주로 공유기에서 사용하는 IP 대역) 를 실습에 사용
해당 IP로 연결패킷을 보내지만, IP를 사용하는 서버가 없으므로 TCP 응답이 오지 않음

혹은 해당 IP로 연결 패킷을 보내지만, 해당 서버가 너무 바쁘거나 문제가 있어서 응답 패킷을 보내지 못하는 경우도 있음
이 때 대기시간?
-> TCP 연결 시도 시 연결 응답이 없을 때, OS에는 연결 대기 타임아웃 설정돼있음
    (버전, 환경마다 상이할 수 있음)
    - window: 약 21초
    - Linux: 약 75~180초 사이
    - mac text: 75초

    해당 시간 초과 시 ConnectionException 발생 (Operation timed out)
    
이렇게 오래 대기하는 것은 좋지 않은 방법
*/