package ch25exception.section3practice.step5finally;


public class NetworkServiceV2_5 {

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
        } finally {
            client.disconnect();
        }
        /*
         try 코드블럭이 시작하기만하면, finally 코드 블럭은 어떤 경우라도 반드시 호출
         catch 문에서 잡을 수 없는 예외가 발생해도 반드시 호출


         참고) catch 문 없이 try~ finally 만 사용할 수도 있음
                직접 처리하지 않고 예외를 밖으로 던지는 경우에도 finally 호출 보장
        */

    }

}
