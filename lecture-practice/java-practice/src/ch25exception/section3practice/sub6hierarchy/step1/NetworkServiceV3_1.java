package ch25exception.section3practice.sub6hierarchy.step1;


import ch25exception.section3practice.sub6hierarchy.step1.exception.*;

/*
*  기존(버전2): NetworkClientException 하나로 관리 (그 안에 어떤 에러인지 에러코드를 따로 담았었음)
   현재(버전3): 예외를 세분화 (예외 객체 자체만으로 어떤 에러인지 구분이 가능해짐) -> 예외에 따라 다른 로직수행이 가능
* */
public class NetworkServiceV3_1 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);

        } catch (ConnectException e) {
            System.out.printf("[connect error] address: %s, message: %s \n",
                    e.getAddress(), e.getMessage());

        } catch (SendException e) {
            System.out.printf("[send error] send data: %s, message: %s \n",
                    e.getSendData(), e.getMessage());
        } finally {
            client.disconnect();
        }
        /* 
        - 예외클래스를 각각의 예외상황에 맞추어 만들면, 각 필요에 맞는 예외를 잡아서 처리가능
        - 각각의 예외 클래스가 가지는 고유의 기능 활용 가능
            - ConnectException -> getAddress()
            - SendException -> getSendData()
        */

    }

}
