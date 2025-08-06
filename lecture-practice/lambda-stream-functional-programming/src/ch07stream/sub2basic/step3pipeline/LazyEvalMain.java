package ch07stream.sub2basic.step3pipeline;

import ch04applylambda.sub4stream.step3generic.MyStreamV3;

import java.util.List;

// 파이프라인
public class LazyEvalMain {
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    // 일괄처리 방식
    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        List<Integer> result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.printf("filter() 실행:  %d (%b)\n", i, isEven);
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.printf("map() 실행:  %d -> %d\n", i, mapped);
                    return mapped;
                }).toList();

        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==\n");
    }

    // 파이프라인 방식
    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        List<Integer> result = data.stream()
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
                )
                .toList();
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
result = [20, 40, 60]
== MyStreamV3 종료 ==

== Stream API 시작 ==
filter() 실행:  1 (false)
filter() 실행:  2 (true)
map() 실행:  2 -> 20
filter() 실행:  3 (false)
filter() 실행:  4 (true)
map() 실행:  4 -> 40
filter() 실행:  5 (false)
filter() 실행:  6 (true)
map() 실행:  6 -> 60
result = [20, 40, 60]
== Stream API 종료 ==

*/

/* 일괄처리 VS 파이프라인

일괄처리는 모든 요소의 한 작업을 끝내고 다음 단계 작업으로 넘어간다.
   중간 연산을 단계별로 쪼개서 데이터 전체를 한 번에 처리하고 결과를 저장해뒀다가
   다음 공정을 또 한 번에 수행

    ex)
    처리 데이터: a,b,c
    연산 과정) 1번 연산 -> 2번 연산 -> 최종연산

    1. a,b,c -> 1번연산
    2. 1번 연산에 통과한 요소들 -> 2번 연산
    3. 2번 연산에 통과한 요소들 -> 최종연산



파이프라인 처리 방식은 한 요소가 하나의 작업이 처리되면 바로 다음 단계로 넘어간다.
    한 요소씩 꺼내서 완료까지 처리하는 것을 반복  (데이터를 모아서 한 방에 처리하지 않는다.)

    ex)
    처리 데이터: a,b,c
    stream 연산 과정) 1번 연산 -> 2번 연산 -> 최종연산

    (중간에 연산에 통과하지 못하여 최종연산에 도달하지 못할 수 있음)
    1. a -> 1번연산 -> 2번 연산 -> 최종연산
    2. b -> 1번연산 -> 2번 연산 -> 최종연산
    3. c -> 1번연산 -> 2번 연산 -> 최종연산
*/