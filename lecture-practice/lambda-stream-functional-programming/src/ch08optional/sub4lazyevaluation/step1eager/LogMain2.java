package ch08optional.sub4lazyevaluation.step1eager;

import ch08optional.sub4lazyevaluation.Logger;

public class LogMain2 {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.setDebug(true);
        logger.debug(10 + 20);

        System.out.println("=== DEBUG OFF ===");
        logger.setDebug(false);
        logger.debug(value100() + value200());


        /* 결과
        [DEBUG] 30
        === DEBUG OFF ===
        value100 호출
        value200 호출

        => 결국 괄호안의 연산이 먼저 수행되어 인수로 넘어간다
        */


        // 인수로 넘기는 값들의 연산을 자체를 수행하지 않으려면
        // 코드 마지막에 디버그 모드 체크 로직 추가 (모드 체크를 호출 메서드 내부가 아닌, 호출하는 외부에서 체크)
        System.out.println("=== Check DEBUG mode");
        if(logger.isDebug()){
            logger.debug(value100() + value200());
        }
        // => 하지만 이런 방식은 디버그를 출력할 때마다 매번 if문 사용해야함

    }

    static int value100() {
        System.out.println("value100 호출");
        return 100;
    }

    static int value200() {
        System.out.println("value200 호출");
        return 200;
    }
}

/*

호출하는 곳에서의 if문 체크를 통해
필요없는 연산을 수행하지 않을 수 있으나, 코드가 지저분해진다.

체크가 없던 기존 방식은 필요없는 연산을 수행하지만, 코드 자체는 비교적 깔끔했다.
깔끔하지만, 사용하지 않게 될 연산이 미리 수행되지 않도록 할 방법이 없는가?

    연산을 정의하는 시점과 해당 연산을 실행하는 시점을 분리해야한다.
    연산의 실행을 최대한 지연해서 평가(계산)
        => 지연평가

next step) 연산을 정의하는 시점과 해당 연산을 실행하는 시점을 분리해보자
    - 익명 클래스나 람다를 만들고, 나중에 호출
*/