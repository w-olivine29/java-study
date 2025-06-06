package ch25exception.section3practice.sub6hierarchy.step2;


import ch25exception.section3practice.sub6hierarchy.step2.exception.*;


public class NetworkServiceV3_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);

            //중요한 오류 순대로 catch문 배치 (상속구조에 있을 경우 더 디테일한 자식을 더 앞에 둔다)
            //상황에 따라서는 한 catch문에 (예외클래스1 || 예외클래스2  변수) 로 배치가능
        } catch (ConnectException e) {
            System.out.printf("[connect error] address: %s, message: %s \n",
                    e.getAddress(), e.getMessage());

        } catch (NetworkClientExceptionV3 e) { //SendException 는 여기서 잡힘
            System.out.printf("[network error] message: %s \n", e.getMessage());

        } catch (Exception e) { // 예상치 못한 예외
            System.out.printf("[unknown error] message: %s \n", e.getMessage());

        } finally {
            client.disconnect();
        }


    }

}
