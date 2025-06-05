package ch25exception.section2basic.unchecked;

// RuntimeException을 상속받은 예외는 언체크 예외
public class MyUncheckedException extends RuntimeException {

    public MyUncheckedException(String message) {
        super(message);
    }


}
