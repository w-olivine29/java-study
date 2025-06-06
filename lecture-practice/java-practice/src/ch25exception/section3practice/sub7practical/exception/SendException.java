package ch25exception.section3practice.sub7practical.exception;


/* 메세지 전송 실패 시 발생하는 예외
 * 전송 실패한 메세지를 보관
 * */
public class SendException extends NetworkClientExceptionV4 {

    private String sendData;

    public SendException(String sendData, String message) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
