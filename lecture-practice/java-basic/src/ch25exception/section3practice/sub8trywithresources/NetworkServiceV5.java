package ch25exception.section3practice.sub8trywithresources;


public class NetworkServiceV5 {

    public void sendMessage(String data) {
        String address = "http://example.com";


        // 반납자원을 try() 안에 넣어준다. (AutoCloseable 구현한 클래스 객체)
        try (NetworkClientV5 client = new NetworkClientV5(address)) {
            client.initError(data);
            client.connect();
            client.send(data);
        }

        /*
         try 블록을 나가는 순간 (정상 종료이든 예외 발생이든 상관없이)
         AutoCloseable의 close()가 자동으로 호출됨 (catch 블록보다 먼저 실행됨)

         참고: finally 블록은 catch 블록 이후에 실행됨
        */


        /* try-with-resources 문에서 AutoCloseable 객체를 여러 개 선언가능

         세미콜론으로 구분
         try (
            Resource1 res1 = new Resource1();
            Resource2 res2 = new Resource2();
            ){ 실행문 }
        */

    }

}
