package ch24nestedclasses.section3local.sub2anonymous.step3lambda;

import java.util.Random;

/* 람다
- 익명 함수를 의미
- 함수를 값처럼 전달할 수 있게 해주는 문법 (클래스나 인스턴스 정의하지않고 코드블럭을 직접 전달)

목적: 메서드(동작)를 다른 메서드의 인수로 전달하거나 변수처럼 저장할 수 있도록 함
전제: 함수형 인터페이스가 필요 (단 하나의 추상 메서드만 가진 인터페이스)


(parameters) -> { body }

 ( -> ) : 입력이 이 코드를 실행한다.
* */
public class Refactoring2 {

    public static void hello(Processor processor) {
        System.out.println("start program"); //변하지 않는 부분
        processor.run(); //변하는 부분
        System.out.println("end program"); //변하지 않는 부분
    }

    public static void main(String[] args) {

        hello(() -> {
                    int randomValue = new Random().nextInt(1, 7);
                    System.out.println("result: " + randomValue);
                }
        );

        hello(() -> {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("i = " + i);
                    }
                }
        );
    }
}

