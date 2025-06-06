package ch25exception.section3practice.sub7practical.exception;


public class NetworkClientExceptionV4 extends RuntimeException { // 접속, 전송


    public NetworkClientExceptionV4(String message) {
        super(message); //스택트레이스에 같이 출력되어 나옴
    }

}
