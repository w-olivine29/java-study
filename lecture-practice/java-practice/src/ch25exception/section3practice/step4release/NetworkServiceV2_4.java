package ch25exception.section3practice.step4release;


/*
 - catch 문에서 잡을 수 없는 예외 발생 시 disconnect()가 호출되지 않아 연결이 해제되지 않는 문제
 */
public class NetworkServiceV2_4 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);

            throw new RuntimeException("catch 문에서 잡을 수 없는 예외발생 가정");
        } catch (NetworkClientExceptionV2 e) {
            System.out.printf("[network error] error code: %s, message: %s \n",
                    e.getErrorCode(), e.getMessage());
        }

        client.disconnect();
        /*
         NetworkClientExceptionV2가 발생하면, 예외 복구되어 disconnect() 실행가능하지만,
         다른 예외가 발생하는 등의 문제 발생 시 예외복구 없이 무시되어 disconnect()가 호출되지 않을 수 있음
         
         모든 상황을 고려하여, disconnect() 호출을 보장받을 필요가 있음 -> finally 도입
        */

    }

}
