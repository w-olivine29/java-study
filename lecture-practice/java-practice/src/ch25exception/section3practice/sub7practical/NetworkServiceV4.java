package ch25exception.section3practice.sub7practical;


/*
*  기존(~버전3):
      - NetworkClientException 의 예외를 service 단에서 catch
   현재(버전4):
      - NetworkClientException 를 체크예외에서 언체크예외로 변경
      - 발생한 예외를 한 곳에서 공통처리
* */
public class NetworkServiceV4 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);


        try {
            client.connect();
            client.send(data);
        } finally {
            client.disconnect();
        }

        /*
        ConnectException , SendException 은 자바 프로그램 상에서 해결할 수 없는 예외라는 설정 (catch 에서 잡아봤자 의미 x)
        catch 나 throws로 무조건 처리해야하는 체크 예외가 아닌 언체크예외로 변경
        해결할 수 없는 예외들은 다른 곳에서 공통으로 처리하게끔 한다.
        */

    }

}
