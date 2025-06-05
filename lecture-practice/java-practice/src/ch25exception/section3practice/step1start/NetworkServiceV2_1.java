package ch25exception.section3practice.step1start;


/*
 - 예외 처리는 적용되었으나 복구 로직이 없어 예외 발생 시 프로그램이 종료
 - 예외 발생 시 disconnect()가 호출되지 않아 연결이 해제되지 않는 문제
 */
public class NetworkServiceV2_1 {

    public void sendMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        client.connect();
        client.send(data);

        client.disconnect();
    }

}
