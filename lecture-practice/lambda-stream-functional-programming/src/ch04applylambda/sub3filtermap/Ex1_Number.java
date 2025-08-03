package ch04applylambda.sub3filtermap;

import java.util.ArrayList;
import java.util.List;

import static ch04applylambda.sub1filter.step3generic.GenericFilter.filter;
import static ch04applylambda.sub2map.step3generic.GenericMapper.map;

/* 필터와 맵 활용

- 리스트에 있는 값 중에 짝수만 남기고, 남은 짝수 값의 2배 반환

문제를 두가지 종류로 풀어보기
-  direct() 에 람다, 유틸리티 사용x , for, if 등으로 직접 작성
- lambda에 앞서 작성한 필터와 맵 유틸리티를 사용하여 코드 작성
*/
public class Ex1_Number {
    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<Integer> direct(List<Integer> numbers) {

        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) { //필터링
                result.add(number * 2); // 매핑
            }
        }
        return result;
    }

//    private static List<Integer> direct(List<Integer> numbers) {
//
//        List<Integer> result = new ArrayList<>();
//        for (Integer number : numbers) {
//            if (number % 2 == 0) {
//                result.add(number);
//            }
//        }
//        result.replaceAll(integer -> (integer * 2));   //default void replaceAll(UnaryOperator<E> operator)

    /// /        for (int i = 0; i < result.size(); i++) {
    /// /            result.set(i, (result.get(i) * 2));
    /// /        }
//
//        return result;
//    }

    private static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> filtered = filter(numbers, num -> num % 2 == 0);

        return map(filtered, num -> num * 2);
    }
}
/* 두 메서드의 차이점

- direct()
    - 프로그램을 "어떻게" 수행해야하는지에 대한 수행 절차 명시
        -> 명령형 프로그래밍 방식
            (익숙하고, 직관적이나, 로직이 복잡해질수록 반복 코드가 많아질 수 있음)

- lambda() 
    - "무엇을" 수행해야하는지 원하는 결과에 초점을 둠
    - 특정 조건으로 필터하고 변환하라고 선언하면 구체적인 부분은 내부에서 수행
    - 개발자는 내부가 아닌 무엇을 해야하는가에 초점을 둠
        - ex) 실제 어떻게 for문, if문 등을 사용해서 필터링, 변환할지 개발자가 크게 신경쓰지 않음
        -> 선언적 프로그래밍 방식
*/

/*
- 명령형 프로그래밍
    - 프로그램이 어떻게 수행되어야 하는지, 즉 수행 절차를 명시하는 방식이다.
        - 단계별 실행: 프로그램의 각 단계를 명확하게 지정, 순서대로 실행
        - 상태 변화: 프로그램의 상태(변수 값 등)가 각 단게별로 어떻게 변화하는지 명시
        - 낮은 추상화: 내부 구현을 직접 제어해야하므로 추상화 수준이 낮음
        - 장점: 시스템의 상태와 흐름을 세밀하게 제어가능
        - ex) 전통적인 for 루프, while 루프 등 명시적 사용

- 선언적 프로그래밍
    - 프로그램이 "무엇을 수행"해야 하는지, 즉 "원하는 결과"를 명시하는 방식
        - 문제해결에 집중: 어떻게 해결하지보다 "무엇을 원하는지"에 초점
        - 코드 간결성: 간결하고 읽기 쉬운 코드 작성가능
        - 높은 추상화: 내부 구현을 숨기고 원하는 결과에 집중할 수 있도록 추상화 수준을 높임
        - 장점: 코드가 간결, 의도 명확, 유지보수가 쉬운 경우가 많음
        - ex) filter,map 등 람다의 고차 함수 활용 , HTML, SQL 등


명령형 프로그래밍: 프로그램이 수행해야 할 각 단계와 처리 과정을 상세하게 기술 "어떻게" 결과에 도달할지를 명시

선언적 프로그래밍: 원하는 결과나 상태 기술, 그 결과를 얻기 위한 내부 처리 방식은 추상화돼있어 
개발자가 무엇을 원하는지에 집중 할 수 있게 함
    람다같은 도구 사용 시 코드 간결하게 작성하여 선언적 스타일로 문제 해결 가능
*/