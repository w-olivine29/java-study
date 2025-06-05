package ch25exception.section3practice.step2recovery;


/*
 - 예외 처리는 적용되었으나 정상흐름과 예외흐름이 섞여있는 상태
 - 예외 발생 시 disconnect()가 호출되지 않아 연결이 해제되지 않는 문제
 */
public class NetworkServiceV2_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            client.connect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.printf("[network error] error code: %s, message: %s \n",
                    e.getErrorCode(), e.getMessage());
            return;
        }

        try {
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.printf("[network error] error code: %s, message: %s \n",
                    e.getErrorCode(), e.getMessage());
            return;
        }

        client.disconnect();
    }

}
