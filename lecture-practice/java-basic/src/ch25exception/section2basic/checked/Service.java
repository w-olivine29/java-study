package ch25exception.section2basic.checked;

public class Service {
    Client client = new Client();

    // 예외를 잡아서 처리하는 코드
    public void callCatch() {

        try {
            client.call();
        } catch (Exception e) { // MyCheckedException -> Exception (다형성 적용)
            //예외처리 로직
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println("정상 흐름");
    }

    // 체크 예외를 밖으로 던지는 코드
    public void catchThrow1() throws MyCheckedException {
        client.call();

        // 위 코드에서 예외발생 시 도달 x
        System.out.println("정상 흐름");
    }

    public void catchThrow2() throws Exception {  // MyCheckedException -> Exception (다형성 적용)
        client.call();

        // 위 코드에서 예외발생 시 도달 x
        System.out.println("정상 흐름");
    }
}
