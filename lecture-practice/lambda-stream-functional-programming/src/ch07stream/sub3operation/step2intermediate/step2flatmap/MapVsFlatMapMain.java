package ch07stream.sub3operation.step2intermediate.step2flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// 중첩 컬렉션을 다룰 땐 FlatMap을 사용하자
// flatMap 은 중첩구조(컬렉션 안의 컬렉션, 배열 안의 배열 등) 을 일차원으로 펼치는 데 사용됨
public class MapVsFlatMapMain {
    public static void main(String[] args) {

        // 해당 리스트를 하나의 리스트로 만들어보자 (평탄화)
        List<List<Integer>> outerList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6),
                List.of(7, 8)
        );
        System.out.println("outerList = " + outerList); // [[1, 2], [3, 4], [5, 6], [7, 8]]

        // for ========================================================================
        List<Integer> forResult = new ArrayList<>();
        for (List<Integer> list : outerList) {
            for (Integer integer : list) {
                forResult.add(integer);
            }
        }
        System.out.println("forResult = " + forResult); //[1, 2, 3, 4, 5, 6, 7, 8]

        // map ========================================================================
        List<Stream<Integer>> mapResult = outerList.stream()
                .map(list -> list.stream())
                .toList(); // 바깥에 있는 스트림만 리스트화
        System.out.println("mapResult = " + mapResult); //[stream객체 참조값, .....]

        // flatMap ========================================================================
        List<Integer> flatMapResult = outerList.stream()

                //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
                .flatMap(list -> list.stream()) // Stream<Integer> 반환
                .toList();

            /* flatMap 호출 시
            1. list -> list.stream() 호출하면서 내부에 있는 요소(List<Integer>) 를 Stream<Integer>로 변환
            2. Stream<Integer> 내부의 값을 꺼내서 외부 Stream 에 포함
            */
        System.out.println("flatMapResult = " + flatMapResult); //[1, 2, 3, 4, 5, 6, 7, 8]
    }
}
