package ch25exception.section3practice.sub6hierarchy.step2.exception;

/* 연결 실패 시 발생하는 예외
* 내부에 연결 시도한 address 보관
* */
public class ConnectException extends NetworkClientExceptionV3 {

    private String address;
    
    public ConnectException(String address, String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
