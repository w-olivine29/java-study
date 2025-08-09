package ch07stream.sub4collectors.step2aggregation;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors5Reducing {
    public static void main(String[] args) {
        List<String> cheeses = List.of("Brie", "Camembert", "Cream cheese", "Ricotta");

        // 컬렉션의 리듀싱은 주로 다운 스트림 활용
        // 모든 이름을 하나의 문자열로 이어 붙이기
        String joined1 = cheeses.stream()
                .collect(Collectors.reducing((c1, c2) -> c1 + " & " + c2))
                .orElseThrow();
        System.out.println("joined1 = " + joined1);

        // ==============================================================================================
        String joined2 = cheeses.stream()
                .reduce((c1, c2) -> c1 + " & " + c2)
                .orElseThrow();
        System.out.println("joined2 = " + joined2);


        // 문자열 전용 기능 ==============================================================================================
        String joined3 = cheeses.stream()
                .collect(Collectors.joining(" & "));
        System.out.println("joined3 = " + joined3);

        String joined4 = String.join(" & ", cheeses);
        System.out.println("joined4 = " + joined4);
    }
}
