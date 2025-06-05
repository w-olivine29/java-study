package ch25exception.section1necessity.step1start;

public class NetworkClientV0 {

    private final String address;

    public NetworkClientV0(String address) {
        this.address = address;
    }


    public String connect() { // 외부서버 연결
        //연결 성공
        System.out.println(address + " - Connection successful");
        return "success";
    }

    public String send(String data) {
        //전송 성공
        System.out.println(address + " - data transfer: " + data);
        return "success";
    }

    public void disconnect() {
        System.out.println(address + " - Disconnect");
    }
}
