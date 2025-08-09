package ch07stream.sub4collectors.step3downstream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {
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
        Map<Integer, List<Student>> collect1_1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade, // 그룹화 기준: 학년
                        Collectors.toList() // 다운스트림: 학생을 리스트로 수집
                ));
        System.out.println("collect1_1 = " + collect1_1);

        // 다운스트림에서 toList() 생략 가능
        Map<Integer, List<Student>> collect1_2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade // 그룹화 기준: 학년
                        // 다운스트림 생략
                ));
        System.out.println("collect1_2 = " + collect1_2); // collect1_1 과 동일

        // 2단계: 학년별로 학생들의 이름을 출력 ==================================================================================
        Map<Integer, List<String>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,  // 그룹화 기준: 학년
                        Collectors.mapping(
                                Student::getName, // 다운스트림 1:  학생 -> 이름 변환
                                Collectors.toList()) // 다운스트림 2: 변환된 값을 List 로 수집
                ));
        System.out.println("collect2 = " + collect2); // {1=[Brie, Cream cheese, Cheddar], 2=[Camembert, Cottage cheese], 3=[Ricotta, Mascarpone]}


        // 3단계: 학년별로 학생들의 수 출력 ==================================================================================
        Map<Integer, Long> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,  //그룹화 기준: 학년
                        Collectors.counting()
                ));
        System.out.println("collect3 = " + collect3); //{1=3, 2=2, 3=2}

        // 4단계: 학년별로 학생들의 평균 성적 출력 ==================================================================================
        Map<Integer, Double> collect4 = students.stream()
                .collect(Collectors
                        .groupingBy(
                                Student::getGrade,
                                Collectors.averagingDouble(Student::getScore)
                        ));
        System.out.println("collect4 = " + collect4);
    }
}
