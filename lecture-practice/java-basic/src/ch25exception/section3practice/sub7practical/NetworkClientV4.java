package ch25exception.section3practice.sub7practical;


import ch25exception.section3practice.sub7practical.exception.ConnectException;
import ch25exception.section3practice.sub7practical.exception.SendException;

/*
*  기존(~버전3):
      - NetworkClientException 의 예외를 service 단에서 catch
   현재(버전4):
      - NetworkClientException 를 체크예외에서 언체크예외로 변경
      - 발생한 예외를 한 곳에서 공통처리
* */
public class NetworkClientV4 {

    private final String address;

    // 기본 초기값은 false
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV4(String address) {
        this.address = address;
    }


    // ConnectException, SendException은 RuntimeException 이므로 throws 명시안해도됨
    public void connect() { // 외부서버 연결
        if (connectError) {
            throw new ConnectException(
                    address, address + " - Connection fail");
        }

        //연결 성공
        System.out.println(address + " - Connection successful");
    }

    public void send(String data) {
        if (sendError) {
            throw new SendException(
                    data, address + " - send fail");
        }

        //전송 성공
        System.out.println(address + " - data transfer: " + data);
    }

    public void disconnect() {
        System.out.println(address + " - Disconnect");
    }

    //에러 활성화
    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
