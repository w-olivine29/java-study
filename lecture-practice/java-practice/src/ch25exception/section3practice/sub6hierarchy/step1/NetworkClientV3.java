package ch25exception.section3practice.sub6hierarchy.step1;


import ch25exception.section3practice.sub6hierarchy.step1.exception.*;

/*
*  기존(버전2): NetworkClientException 하나로 관리 (그 안에 어떤 에러인지 에러코드를 따로 담았었음)
   현재(버전3): 예외를 세분화 (예외 객체 자체만으로 어떤 에러인지 구분이 가능해짐) -> 예외에 따라 다른 로직수행이 가능
* */
public class NetworkClientV3 {

    private final String address;

    // 기본 초기값은 false
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV3(String address) {
        this.address = address;
    }


    public void connect() throws ConnectException { // 외부서버 연결
        if (connectError) {
            throw new ConnectException(
                    address, address + " - Connection fail");
        }

        //연결 성공
        System.out.println(address + " - Connection successful");
    }

    public void send(String data) throws SendException {
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
