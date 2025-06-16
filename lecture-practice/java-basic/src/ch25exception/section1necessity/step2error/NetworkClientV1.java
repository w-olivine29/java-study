package ch25exception.section1necessity.step2error;

/* 에러 시뮬레이션
- 연결실패
    - 사용자가 입력하는 문자에 "error1" 단어가 있으면 연결 실패
    - 오류코드: "connectError"
- 전송실패
    - 사용자가 입력하는 문자에 "error2" 단어가 있으면 데이터 전송 실패
    - 오류코드: "sendError"
* */

public class NetworkClientV1 {

    private final String address;

    // 기본 초기값은 false
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }


    public String connect() { // 외부서버 연결
        if (connectError) {
            System.out.println(address + " - Connection fail");
            return "connectError";
        }

        //연결 성공
        System.out.println(address + " - Connection successful");
        return "success";
    }

    public String send(String data) {
        if (sendError) {
            System.out.println(address + " - send fail");
            return "sendError";
        }

        //전송 성공
        System.out.println(address + " - data transfer: " + data);
        return "success";
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
