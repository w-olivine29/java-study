package ch25exception.section3practice.sub3flowseparation;


/*
 - 정상, 예외 흐름 분리 
    - try <- 모든 정상로직
    - catch <- 예외복구 로직
 - 예외 발생 시 disconnect()가 호출되지 않아 연결이 해제되지 않는 문제
 */
public class NetworkServiceV2_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        //정상, 예외 흐름을 분리
        try {
            client.connect();
            client.send(data);
            client.disconnect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.printf("[network error] error code: %s, message: %s \n",
                    e.getErrorCode(), e.getMessage());
        }
        
        /* sendMessage 호출 시
         * connect() 에서 예외발생 -> 바로 catch문 진입 -> disconnect() 도달 x
         * send() 에서 예외발생 -> 바로 catch문 진입 -> disconnect() 도달 x
         * */

    }

}
