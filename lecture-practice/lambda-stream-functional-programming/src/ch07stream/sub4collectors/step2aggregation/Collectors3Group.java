package ch07stream.sub4collectors.step2aggregation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors3Group {
    public static void main(String[] args) {

        List<String> cheezes = List.of(
                "Brie",
                "Camembert",
                "Cream cheese",
                "Ricotta",
                "Cottage cheese",
                "Mascarpone",
                "Cheddar",
                "Mozzarella");

        // groupingBy - 첫 글자 알파벳을 기준으로 그룹화 ================================================================================
        // 특정 기준에 따라 스트림 요소를 여러 그룹으로 묶는다
        Map<String, List<String>> grouped = cheezes.stream()
                .collect(Collectors.groupingBy(cheeze -> cheeze.substring(0, 1)));
        System.out.println("grouped = " + grouped);
        //grouped = {R=[Ricotta], B=[Brie], C=[Camembert, Cream cheese, Cottage cheese, Cheddar], M=[Mascarpone, Mozzarella]}


        // partitioningBy - 짝수인지 여부로 분할(파티셔닝) ================================================================================
        // 단순하게 true 와 false 두 그룹으로 나눈다.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("partitioned = " + partitioned); //partitioned = {false=[1, 3, 5], true=[2, 4, 6]}
    }
}

