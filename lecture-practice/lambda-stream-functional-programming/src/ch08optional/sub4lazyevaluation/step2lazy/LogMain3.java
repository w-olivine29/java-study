package ch08optional.sub4lazyevaluation.step2lazy;

import ch08optional.sub4lazyevaluation.Logger;

public class LogMain3 {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.setDebug(true);
        logger.debug(10 + 20);

        System.out.println("=== DEBUG OFF ===");
        logger.setDebug(false);
        logger.debug(()-> value100() + value200()); // 1.인수로 넘길 때 실행되는 것이 아닌 해당 연산을 하는 람다를 정의한 것을 보낼 뿐

        /*
        public void debug(Supplier<?> supplier){
            if(isDebug => false){ 2. debug 모드가 꺼져있으므로 false -> 받아온 람다를 실행 x
                System.out.println("[DEBUG] " + supplier.get());
            }
        }
        => LogMain2 보다 깔끔하고, 지연연산을 할 수 있게 되었다.
        */
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
람다를 활용하여
연산을 정의하는 시점과 실행(평가)하는 시점을 분리
=> 값이 실제로 필요할 때까지 연산을 미룰 수 있게 됨


즉시평가
    값(혹은 객체)를 바로 생성하거나 계산하는 것

지연 평가
    값이 실제로 필요할때 (사용될 때) 까지 계산을 미루는 것
    
    => 이 특성 덕분에 스트림이 지연 연산이 가능한 것
*/


/*
람다를 제공하는 많은 라이브러리들이 있는데,
즉시평가와 지연평가하는 메서드가 나눠져서 제공되는 경우들이 있는데,
이 개념을 알아놔야 제대로 파악하고 활용할 수 있을 것이다!
*/