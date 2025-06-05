package ch25exception.section2basic.unchecked;

/*
언체크 예외는
직접 잡거나, 던지지 않아도 됨 (자동처리)
* */
public class Service {
    Client client = new Client();

    // 예외를 잡아서 처리하는 코드
    public void callCatch() {

        try {
            client.call();
        } catch (MyUncheckedException e) {
            //예외처리 로직
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println("정상 흐름");
    }

    // 체크 예외를 밖으로 던지는 코드
    public void catchThrow(){
        client.call();

        // 위 코드에서 예외발생 시 도달 x
        System.out.println("정상 흐름");
    }
}
