package ch04network.sub5execption.connect.step2timeout;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketTimeoutClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 12345);

        InputStream inputStream = socket.getInputStream();
        try{
            socket.setSoTimeout(2000); // 타임아웃 설정 (코드 중간 중간에 여러번 새로 설정 가능)
            int read = inputStream.read(); // 현재 서버에서 아무 응답도 주지 않는 상태 -> 타임아웃 설정이 없으면 무한 대기중
            System.out.println("read = " + read);
        }catch (Exception e){
            e.printStackTrace(); //SocketTimeoutException: Read timed out
        }
        inputStream.close();
        socket.close();
    }
}
/*
실무에서 자주 발생하는 장애 원인 중 하나가 연결 타임아웃, 소켓 타임아웃(read 타임 아웃) 을 누락하기 때문에 발생

장애 발생 과정)
타임아웃 미설정 → 네트워크 요청이 무한 대기
스레드 블로킹 → 응답을 기다리는 스레드가 계속 점유됨
스레드 풀 고갈 → 새로운 요청을 처리할 스레드가 부족해짐
서비스 응답 불가 → 전체 애플리케이션이 마비 상태가 됨

외부 서버와 통신하는 경우 반드시 연결 타임아웃 & 소켓 타임아웃 지정!!!!!!!
*/