package ch25exception.section1necessity.step1start;

// 복잡한 NetworkClient 사용 로직 처리
public class NetworkServiceV0 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV0 client = new NetworkClientV0(address);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
