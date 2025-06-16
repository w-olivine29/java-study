package ch25exception.section2basic.checked;

public class Client {

    public void call() throws MyCheckedException { //throws:  메서드 안에서 발생한 예외를 밖으로 던진다

        // throw: 예외발생
        throw new MyCheckedException("exception"); //예외도 객체이기때문에 new연산자로 생성 후 예외발생
    }
}
