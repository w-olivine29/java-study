package ch07stream.sub2basic.step4lazy;

import ch04applylambda.sub4stream.step3generic.MyStreamV3;

import java.util.List;

// 파이프라인
public class LazyEvalMain2_LazyEvaluation {
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    // 일괄처리 & 즉시 연산
    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.printf("filter() 실행:  %d (%b)\n", i, isEven);
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.printf("map() 실행:  %d -> %d\n", i, mapped);
                    return mapped;
                });

        System.out.println("== MyStreamV3 종료 ==\n");
    }

    // 파이프라인 처리 & 지연 연산
    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        data.stream()
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
                );
        System.out.println("== Stream API 종료 ==\n");
    }
}
/*
모든 방식에서 최종연산인 toList() 제거

최종 연산의 유무와는 상관없이 중간연산 진행
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
    == MyStreamV3 종료 ==



최종 연산이 없으면 연산 진행 x (지연 연산)
== Stream API 시작 ==
== Stream API 종료 ==

*/

/*
스트림 API 의 지연 연산

- 중간 연산들은 "이런 연산을 할 것이다" 라는 파이프라인 설정만 해놓고,
    실제 연산은 최종 연산이 호출되기 전 까지 진행 x
*/


/*
next step)
    stream API 지연연산 장점 알아보기
 
*/