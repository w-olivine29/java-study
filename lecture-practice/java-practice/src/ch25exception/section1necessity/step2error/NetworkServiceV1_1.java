package ch25exception.section1necessity.step2error;


/* next step
    connect() 에서 실패시, send()를 호출하지 말아야하는데, 현재는 호출중인 상태
    NetworkClientV1 에서는 오류코드를 문자열로 반환중 -> 반환 값을 사용해서 예외 상황 처리
* */
public class NetworkServiceV1_1 { // 복잡한 NetworkClient 사용 로직 처리


    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
