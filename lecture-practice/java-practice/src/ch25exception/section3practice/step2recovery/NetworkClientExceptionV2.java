package ch25exception.section3practice.step2recovery;


public class NetworkClientExceptionV2 extends Exception { // 접속, 전송

    private final String errorCode;

    public NetworkClientExceptionV2(String errorCode, String message) {
        super(message); //스택트레이스에 같이 출력되어 나옴
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
