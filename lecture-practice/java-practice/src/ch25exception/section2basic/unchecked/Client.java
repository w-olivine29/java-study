package ch25exception.section2basic.unchecked;


public class Client {

    public void call() { //throws를 명시하지 않아도 알아서 나감

        // throw: 예외발생
        throw new MyUncheckedException("exception");
    }
}
