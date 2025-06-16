package ch25exception.section3practice.sub8trywithresources;


import ch25exception.section3practice.sub8trywithresources.exception.*;


public class NetworkClientV5 implements AutoCloseable {

    private final String address;

    // 기본 초기값은 false
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV5(String address) {
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

    // 연결자원 해제
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

    /* 
    AutoCloseable 인터페이스가 제공하는 close() 은 try가 끝나면 자동 호출
    종료 시점에 자원반납 하는 로직을 close() 안에 정의
    * */
    @Override
    public void close() {
        System.out.println("NetworkClientException.close");
        disconnect(); //연결 자원 해제
    }
}
