package ch04applylambda.sub3filtermap;

import ch04applylambda.sub1filter.step3generic.GenericFilter;
import ch04applylambda.sub2map.step3generic.GenericMapper;

import java.util.ArrayList;
import java.util.List;

/*
 - 점수가 80 점 이상인 학생의 이름 추출
 - direct() 에 람다 사용하지 않고 for, if 등의 코드 직접 작성
 - lambda() 에 앞서 작성한 필터와 맵 유틸리티 클래스 사용하여 코드 작성
*/
public class Ex2_Student {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("학생1", 100),
                new Student("학생2", 20),
                new Student("학생3", 70),
                new Student("학생4", 10),
                new Student("학생5", 80),
                new Student("학생6", 100)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }


    // 어떻게 수행하는지 수행 절차를 명시
    // 어떻게 필터링하고 이름을 추출하는지 for, if 등을 통해 수행 절차를 구체적을 지시
    private static List<String> direct(List<Student> students) {
        List<String> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getScore() >= 80) {
                result.add(student.getName());
            }
        }
        return result;
    }

    // 요구사항과 같이 
    // "점수가 80점 이상인 학생을 추출", "추출한 학생의 이름을 반환" 를 선언적으로 해결
    // 어떻게 하는지 보다 요구사항에 맞추어 무엇을 하고 싶은지에 초점
    private static List<String> lambda(List<Student> students) {
        List<Student> filtered = GenericFilter.filter(students, student -> student.getScore() >= 80);
        return GenericMapper.map(filtered, student -> student.getName());
    }
}
