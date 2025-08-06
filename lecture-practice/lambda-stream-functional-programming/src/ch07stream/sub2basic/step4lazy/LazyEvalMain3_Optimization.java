package ch07stream.sub2basic.step4lazy;

import ch04applylambda.sub4stream.step3generic.MyStreamV3;

import java.util.List;

// 파이프라인
public class LazyEvalMain3_Optimization {
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    // 일괄처리 & 즉시 연산
    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.printf("filter() 실행:  %d (%b)\n", i, isEven);
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.printf("map() 실행:  %d -> %d\n", i, mapped);
                    return mapped;
                }).getFirst();

        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==\n");
    }

    // 파이프라인 처리 & 지연 연산
    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        Integer result = data.stream()
                .filter(i -> {
                            boolean isEven = i % 2 == 0;
                            System.out.printf("filter() 실행:  %d (%b)\n", i, isEven);
                            return isEven;
                        }
                )
                .map(i -> {
                            int mapped = i * 10;
                            System.out.printf("map() 실행:  %d -> %d\n", i, mapped);
                            return mapped;
                        }
                ).findFirst().get(); // findFirst() -> Optional 반환
        System.out.println("result = " + result);
        System.out.println("== Stream API 종료 ==\n");
    }
}
/*

== MyStreamV3 시작 ==
filter() 실행:  1 (false)
filter() 실행:  2 (true)
filter() 실행:  3 (false)
filter() 실행:  4 (true)
filter() 실행:  5 (false)
filter() 실행:  6 (true)
map() 실행:  2 -> 20
map() 실행:  4 -> 40
map() 실행:  6 -> 60
result = 20
== MyStreamV3 종료 ==

== Stream API 시작 ==
filter() 실행:  1 (false)
filter() 실행:  2 (true)
map() 실행:  2 -> 20
result = 20
== Stream API 종료 ==

*/

/*
단축평가(short-circuit) 
    조건을 만족하는 결과를 찾으면 더 이상 연산을 진행하지 않는 방식
    지연연산 * 파이프라인 방식이 있기때문에 가능한 최적화 기법 중 하나

자바 스트림 API는 지연 연산을 사용하므로,
    최종 연산이 호출되기 전까지는 실제 연산 x
    필요할 때는 단축 평가를 통해 불필요한 연산 생략 가능
*/


/* 지연연산에서 얻을 수 있는 장점

- 불필요한 연산 생략(단축, Short-Circuiting)
    - findFirst(), limit() 등의 단축 연산 사용 시, 결과를 찾은 시점에서 더 이상 나머지 요소를 처리 할 필요 X
   
- 메모리 사용 효율
    - 중간 연산 결과를 매 단계마다 별도의 자료구조에 저장 x, 최종 연산 때까지 필요할 때만 가져와서 처리
    
- 파이프라인 최적화
    - 스트림은 요소를 하나씩 꺼내면서(순차적으로) 중간연산들을 묶어서 실행 가능
    - 요소 하나를 꺼내면, 그 요소에 대한 중간연산 -> 최종 연산까지 진행 후 다음 요소로 넘어감
    - 중간단계를 저장하지 않아도 되므로, 내부적으로 효율적으로 동작, 메모리 절약 가능
*/