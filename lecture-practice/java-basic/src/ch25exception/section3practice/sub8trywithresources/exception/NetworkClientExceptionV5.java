package ch25exception.section3practice.sub8trywithresources.exception;


public class NetworkClientExceptionV5 extends RuntimeException { // 접속, 전송


    public NetworkClientExceptionV5(String message) {
        super(message); //스택트레이스에 같이 출력되어 나옴
    }

}
