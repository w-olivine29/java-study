package ch25exception.section3practice.sub1start;


public class NetworkClientExceptionV2 extends Exception { // 접속, 전송에 발생 될 예외

    private final String errorCode;

    // 에러코드로 무슨 예외인지 구분
    public NetworkClientExceptionV2(String errorCode, String message) {
        super(message); //스택트레이스에 같이 출력되어 나옴
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
