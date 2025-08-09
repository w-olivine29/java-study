package ch07stream.sub4collectors.step3downstream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Brie", 1, 85),
                new Student("Camembert", 2, 92),
                new Student("Cream cheese", 1, 78),
                new Student("Ricotta", 3, 88),
                new Student("Cottage cheese", 2, 91),
                new Student("Mascarpone", 3, 95),
                new Student("Cheddar", 1, 82)
        );

        // 1단계: 학년별로 학생들을 그룹화 ==================================================================================
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect1 = " + collect1);


        // 2 단계: 학년별로 가장 점수가 높은 학생 구하기 (reducing 사용) ==================================================================================
        Map<Integer, Optional<Student>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2) // BinaryOperator<T> op

                ));
        System.out.println("collect2 = " + collect2);


        // 3 단계: 학년별로 가장 점수가 높은 학생 구하기 (maxBy 사용) ==================================================================================
        Map<Integer, Optional<Student>> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        //Collectors.maxBy((s1, s2) -> s1.getScore() > s2.getScore() ? 1 : -1) // 0반환은 예제 단순화를 위해 생략
                        //Collectors.maxBy(Comparator.comparingInt(student -> student.getScore()))
                        Collectors.maxBy(Comparator.comparingInt(Student::getScore))

                ));
        System.out.println("collect3 = " + collect3);

        // 4단계: 학년별로 가장 점수가 높은 학생의 이름을 구하기 (CollectingAndThen + maxBy 사용) ==================================================================================
        // 학년별 그룹 -> 그룹별 최고점 학생 -> 그룹별 최고점 학생이름
        // CollectingAndThen: 다운 스트림 컬렉터가 만든 결과를 한 번 더 후처리할 수 있게 해줌
        Map<Integer, String> collect4 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade, //Collector<T,A,R> downstream, Function<R,RR> finisher
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student::getScore)), // 반환 타입: Collector<T, ?, Optional<T>>
                                studentOptional -> studentOptional.orElseThrow().getName()
                        )
                ));
        System.out.println("collect4 = " + collect4);
    }
}

/*
 - mapping()
    - 그룹 내 개별 요소를 변환 후 해당 변환 결과를 다른 Collector 로 수집
    - 그룹화 -> 각 요소 변환 -> List 나 Set 등으로 수집

 - collectingAndThen()
    - 그룹 내 요소들을 이미 한 번 수집한 결과를 추가 가공하거나 최종 타입으로 변환
    - 그룹화 -> 최대값/최솟값/합계 등 수집 -> 결과를 후처리 ex) Optional -> String


mapping() 은 그룹화된 요소 하나하나를 변환하는데 유용,
collectingAndThen() 이미 만들어진 전체 그룹의 결과를 최종 한 번 더 손보는 데 사용
*/