package ch04network.sub5execption.section1connect.step1start;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ConnectMain {
    public static void main(String[] args) throws IOException {
        unknownHostEx1();
        unknownHostEx2();
        connectionRefused();
    }

    private static void unknownHostEx1() throws IOException {

        // 없는 IP 대역의 IP 에 접근 시
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void unknownHostEx2() throws IOException {

        // 없는 도메인 접근
        try {
            Socket socket = new Socket("naver.naver", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void connectionRefused() throws IOException {

        try{
            Socket socket = new Socket("localhost", 123456);
        }catch (ConnectException e){
            e.printStackTrace();
        }

        // 연결이 거절됐다는 것은, 해당 IP 서버 컴퓨터에 접속은 한 것

        // 서버 컴퓨터가 해당 포트를 사용하지 않기에 TCP 연결 거부
        // 네트워크 방화벽 등에서 무단 연결로 인지하고 연결을 막을 때도 발생
        // 서버 컴퓨터의 OS 는 TCP RST(Reset) 이라는 패킷을 보내서 연결 거절 
    }
}

/* next step)
 네트워크 연결을 시도해서 서버 IP에 연결 패킷을 전달했으나 응답이 없는 경우
*/