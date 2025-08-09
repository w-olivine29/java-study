package ch07stream.sub3operation.step3terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        // Collectors 는 뒤에서 저 자세히 (복잡한 수집이 필요할 떄 사용)
        System.out.println("\n\n1. collect - List 수집  ===================================================================");
        List<Integer> evenNumbers1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList()); // Java16 이후 부터는 .toList() 제공
        System.out.println("evenNumbers1 = " + evenNumbers1);


        System.out.println("\n\n2. toList - (Java16++) ===================================================================");
        List<Integer> evenNumbers2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("evenNumbers2 = " + evenNumbers2);


        System.out.println("\n\n3. toArray - 배열로 변환 ===================================================================");
        Integer[] arr = numbers.stream()
                .filter(n -> n % 2 == 0)
                //.toArray(value -> new Integer[value])
                .toArray(Integer[]::new); // <A> A[] toArray(IntFunction<A[]> generator);
        System.out.println("arr = " + Arrays.toString(arr));


        System.out.println("\n\n4. forEach - 각 요소 처리 ===================================================================");
        numbers.stream()
                .limit(3)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();


        System.out.println("\n\n5. count - 요소 개수 ===================================================================");
        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("count = " + count);


        System.out.println("\n\n6. reduce - 요소들의 합 ===================================================================");
        // 초기값이 없는 reduce
        Optional<Integer> sum1 = numbers.stream()
                .reduce((a, b) -> a + b); // Optional<T> BinaryOperator<T> accumulator

        System.out.println("합계(초기값 없음) = " + sum1.get()); //  62

        // 초기값이 있는 reduce (적어도 초기값을 반환할테니 Optional 불필요)
        Integer sum2 = numbers.stream()
                .reduce(100, (a, b) -> a + b); // T reduce(T identity, BinaryOperator<T> accumulator);

        System.out.println("합계(초기값 있음) = " + sum2); // 162


        System.out.println("\n\n7. min - 최솟값 ===================================================================");
        Optional<Integer> min = numbers.stream()
                //.min((x, y) -> x - y); //Optional<T> min(Comparator<? super T> comparator);
                .min(Integer::compareTo); // Comparator 의 compare 함수 내부에서 Integer.compareTo(x,y) 를 호출하는 형태로 구현

        // 기본 오름차순 정렬 Comparator 를 넣으면 내부에서 최솟값을 찾아줌
        System.out.println("최솟값: " + min.get());

        System.out.println("\n\n8. max - 최댓값 ===================================================================");
        Optional<Integer> max = numbers.stream()
                //.max((x, y) -> x - y); //Optional<T> max(Comparator<? super T> comparator);
                .max(Integer::compareTo);

        // 기본 오름차순 정렬 Comparator 를 넣으면 내부에서 최댓값을 찾아줌
        System.out.println("최댓값: " + max.get()); //10


        System.out.println("\n\n9. findFirst - 첫 번째 요소 ===================================================================");
        // 컬렉션 순서대로 돌려서 첫 번쨰 요소 찾기
        Optional<Integer> first = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();

        System.out.println("5보다 큰 첫 번째 요소: " + first.get()); //6

        System.out.println("\n\n10. findAny - 아무 요소 하나 찾기 ===================================================================");

        // 순차 스트림에서는 보통 첫 번째를 반환하지만,
        // 병렬 스트림에서는 어떤 스레드가 먼저 찾느냐에 따라
        // 순서와 무관한 요소를 반환할 수 있음
        // → 병렬 처리 시 성능상 이점
        // 멀티스레드에서는 findAny 가 낫고, 단일 스레드에서는 findFirst, findAny 둘다 거의 같음
        Optional<Integer> any = numbers.stream()
                .filter(n -> n > 5)
                .findAny();

        System.out.println("5보다 큰 아무 요소: " + any.get()); //6


        System.out.println("\n\n11. anyMatch - 조건을 만족하는 요소 존재 여부 ===================================================================");
        boolean hasEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println("hasEven = " + hasEven);


        System.out.println("\n\n12. allMatch - 모든 요소가 조건을 만족하는지 여부 ===================================================================");
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("allPositive = " + allPositive); // true


        System.out.println("\n\n13. noneMatch - 조건을 만족하는 요소가 없는지 ===================================================================");
        boolean noneNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("noneNegative = " + noneNegative); // true

    }
}
