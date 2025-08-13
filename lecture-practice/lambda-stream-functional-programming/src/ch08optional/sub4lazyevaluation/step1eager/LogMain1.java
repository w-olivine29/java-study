package ch08optional.sub4lazyevaluation.step1eager;

import ch08optional.sub4lazyevaluation.Logger;

public class LogMain1 {
    public static void main(String[] args) {
        
        Logger logger = new Logger();

        // 자바 언어의 연산자 우선순위상 메서드 호출 전에 괄호 안의 내용이 먼저 계산
        logger.setDebug(true);
        logger.debug(10 + 20); // 여기서는 10 + 20 즉시 평가 -> logger.debug(30);


        System.out.println("=== DEBUG OFF ===");
        logger.setDebug(false);
        logger.debug(100 + 200); // 1. 여기서는 100 + 200 즉시 평가 -> logger.debug(300);

        /*
        public void debug(Object message => 300){
            if(isDebug => false){ 2. debug 모드가 꺼져있으므로 false -> 실행 x
                System.out.println("[DEBUG] " + message);
            }
        }
        => 결국 100 + 200 은 연산을 수행했지만, 어디에도 사용되지 못하고 버려짐 (CPU 낭비)
            
        */
    }
}
/* next step)
    정말로 100 + 200 연산이 실제로 수행된 것인지 확인해보자
*/