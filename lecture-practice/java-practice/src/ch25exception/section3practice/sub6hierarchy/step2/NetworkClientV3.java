package ch25exception.section3practice.sub6hierarchy.step2;


import ch25exception.section3practice.sub6hierarchy.step2.exception.*;


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
