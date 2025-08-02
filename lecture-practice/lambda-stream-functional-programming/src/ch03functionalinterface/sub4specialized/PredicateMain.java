package ch03functionalinterface.sub4specialized;

import java.util.function.Function;
import java.util.function.Predicate;

// 입력 값: o, 출력 값: boolean
// 대표 사용 예시: 조건검사, 필터링 등
public class PredicateMain {
    public static void main(String[] args) {

        // 익명클래스
        Predicate<Integer> isEven1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println("isEven1.test(5) = " + isEven1.test(5));

        // 람다
        Predicate<Integer> isEven2 = value -> value % 2 == 0;
        System.out.println("isEven2.test(4) = " + isEven2.test(4));
        
    }
}
/* 
Function<Integer, Boolean> function = value -> value % 2 == 0;
와 같은 형식으로 Predicate 가 아닌 Function 으로 구현이 가능하지만 
Predicate를 정의한 이유

"입력값을 받아 true/false 결과를 판단한다" 라는 의도를 명시적으로 드러내기 위함이다.
목적(조건 검사) & 용도(필터링 등)에 대해 더 명확하게 표현, 가독성과 유지보수를 위함


자바가 제공하는 다양한 함수형 인터페이스 선택 시,
단순히 입력값, 반환값만 보고 선택 x
해당 함수형 인터페이스가 제공하는 의도가 중요
*/
