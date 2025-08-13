package ch08optional.sub3valuehandler;

import java.util.Optional;

public class OptionalProcessingMain {
    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Welcome");
        Optional<String> empty = Optional.empty();

        System.out.println("\n== 1. ifPresent() ===========================================");
        // 값이 존재하면 Consumer 실행 (없으면 아무 일도 하지 않음)
        optValue.ifPresent(value -> System.out.println("optValue 값 = " + value));
        empty.ifPresent(value -> System.out.println("empty 값 = " + value)); // 실행 x


        System.out.println("\n== 2. ifPresentOrElse() ===========================================");
        // 값이 있으면 Consumer 실행, 없으면 Runnable 실행
        optValue.ifPresentOrElse(
                value -> System.out.println("optValue 값 = " + value),
                () ->  System.out.println("optValue 는 비어있습니다.")
        );
        empty.ifPresentOrElse(
                value -> System.out.println("empty 값 = " + value),
                () ->  System.out.println("empty 는 비어있습니다.")
        );

        System.out.println("\n== 3. map() ===========================================");
        //값이 있으면 Function 적용 후 Optional로 반환, 없으면 Optional.empty()

        Optional<Integer> lengthMap1 = optValue.map(String::length);
        System.out.println("optValue.map(String::length) = " + lengthMap1); //Optional[7]

        Optional<Integer> lengthMap2 = empty.map(String::length);
        System.out.println("empty.map(String::length) = " + lengthMap2); //Optional.empty


        System.out.println("\n== 4. flatMap() ===========================================");
        // map() 과 유사하나, 이미 Optional을 반환하는 경우 중첩을 제거하고 평탄화해서 반환

        // map() 사용 시 람다에서 옵셔널을 반환하는 경우 중첩 Optional 이 돼버린다.
        System.out.println("[Map - 중첩된 Optional]");
        Optional<Optional<Integer>> nestedOpt = optValue.map(value -> Optional.of(value.length()));
        System.out.println("nestedOpt = " + nestedOpt); //Optional[Optional[7]]

        
        // flatMap()을 사용하면 한 번에 평탄화 (옵셔널을 반환해도 중첩시키지 않고, 하나의 옵셔널로 반환해줌)
        System.out.println("[FlatMap]");
        Optional<Integer> flattedOpt1 = optValue.flatMap(value -> Optional.of(value.length()));
        System.out.println("flattedOpt1 = " + flattedOpt1); //Optional[7]


        System.out.println("\n== 5. filter() ===========================================");
        // 값이 있고 조건을 만족하면 그 값을 그대로, 불만족 시 Optional.empty 반환
        Optional<String> filterOpt1 = optValue.filter(value -> value.startsWith("W"));
        System.out.println("value.startsWith(\"W\") = " + filterOpt1); //Optional[Welcome]

        Optional<String> filterOpt2 = optValue.filter(value -> value.startsWith("K"));
        System.out.println("value.startsWith(\"K\") = " + filterOpt2); //Optional.empty


        System.out.println("\n== 6. stream() ===========================================");
        // 값이 있으면 단일 요소 스트림, 없으면 빈 스트림
        optValue.stream()
                .forEach(value -> System.out.println("opt.stream() -> " + value));

        // 값이 없으므로 실행 x
        empty.stream()
                .forEach(value -> System.out.println("empty.stream() -> " + value));
    }
}
