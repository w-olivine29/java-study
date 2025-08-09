package ch07stream.sub3operation.step2intermediate.step1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 8);

        System.out.println("\n\n1. filter - 짝수만 선택 =======================================================");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));  //2 4 6 6 8


        System.out.println("\n\n2. map - 각 숫자를 제곱 =======================================================");
        numbers.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " ")); //1 4 9 16 25 36 36 49 49 49 64


        System.out.println("\n\n3. distinct - 중복 제거 =======================================================");
        numbers.stream()
                .distinct()
                .forEach(n -> System.out.print(n + " ")); //1 2 3 4 5 6 7 8


        System.out.println("\n\n4. sorted -" + " 기본 정렬 =======================================================");
        Stream.of(4, 2, 6, 0, 7, 9, 8, 1)
                .sorted()
                .forEach(n -> System.out.print(n + " ")); //0 1 2 4 6 7 8 9


        System.out.println("\n\n4. sorted - 커스텀 정렬 =======================================================");
        Stream.of(4, 2, 6, 0, 7, 9, 8, 1)

                // 내림차순 정렬
                .sorted(Comparator.reverseOrder())
                .forEach(n -> System.out.print(n + " ")); //9 8 7 6 4 2 1 0


        System.out.println("\n\n5. peek - 동작 확인용 =======================================================");

        // 데이터 자체에 영향을 주지 않음
        // 파이프 라인 중간에 흐르는 데이터를 중간에 혼자 엿보고 무언가 하는 느낌 (엿보는거라 데이터 자체에는 영향 x)
        numbers.stream()
                .peek(n -> System.out.println("before: " + n + ", "))
                .map(n -> n * n)
                .peek(n -> System.out.println("after: " + n + ", "))
                .limit(5)
                .forEach(n -> System.out.println("최종값: " + n + "\n"));



        System.out.println("\n\n6. limit - 처음 n개 요소만 =======================================================");
        numbers.stream()
                .limit(5)
                .forEach(n -> System.out.print(n + " ")); //1 2 3 4 5



        System.out.println("\n\n7. skip - 처음 n개 요소 건너뛰기 =======================================================");
        numbers.stream()
                .skip(5)
                .forEach(n -> System.out.print(n + " ")); //6 6 7 7 7 8


        System.out.println("\n\n8. takeWhile (Java 9++)  - 조건을 만족하는 동안까지만 추출 =======================================================");
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);

        // filter 와의 차이점
        // 해당 조건의 while문 내에서 각 요소 연산 동작 한다고 보면 된다. (한번이라도 조건 불만족 시 while문 탈출한다고 보면 됨)
        // 그래서 보통은 이미 정렬돼있는 자료에 사용하는 것이 효과적

        // 조건이 처음으로 거짓이 되는 지점에서 스트림을 멈춘다.  while(조건){연산}
        numbers2.stream()
                .takeWhile(n -> n < 5)
                .forEach(n -> System.out.print(n + " ")); //1 2 3 4
        // 조건문이 만족하는 동안 take 해라 (forEach 를)


        System.out.println("\n\n8. dropWhile (Java 9++)  - 조건을 만족하는 동안까지만 건너뛰기 =======================================================");
        
        // 조건을 만족하는 동안 요소를 버리고
        // 조건이 처음으로 거짓이 되는 지점부터 스트림 구성  while(조건){continue} 연산;
        numbers2.stream()
                .dropWhile(n -> n < 5) // 5보다 작은 동안은 건너뛰기 (5를 만나면 조건문 자체를 탈출, 그 이후의 요소들은 조건문 적용 x)
                .forEach(n -> System.out.print(n + " ")); //5 1 2 3
        // 조건문이 만족하는 동안 무시해라 (forEach를)
    }
}
