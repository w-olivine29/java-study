package ch25exception.section3practice.sub4release;


public class NetworkClientV2 {

    private final String address;

    // 기본 초기값은 false
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV2(String address) {
        this.address = address;
    }

    // 외부서버 연결
    public void connect() throws NetworkClientExceptionV2 {
        if (connectError) {
            throw new NetworkClientExceptionV2(
                    "connectError", address + " - Connection fail");
        }

        //연결 성공
        System.out.println(address + " - Connection successful");
    }

    // 데이터전송
    public void send(String data) throws NetworkClientExceptionV2 {
        if (sendError) {
            throw new NetworkClientExceptionV2(
                    "sendError", address + " - send fail");
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
