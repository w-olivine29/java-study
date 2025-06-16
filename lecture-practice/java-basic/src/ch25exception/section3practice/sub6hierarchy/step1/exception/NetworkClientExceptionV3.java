package ch25exception.section3practice.sub6hierarchy.step1.exception;


public class NetworkClientExceptionV3 extends Exception { // 접속, 전송


    public NetworkClientExceptionV3(String message) {
        super(message); //스택트레이스에 같이 출력되어 나옴
    }

}
