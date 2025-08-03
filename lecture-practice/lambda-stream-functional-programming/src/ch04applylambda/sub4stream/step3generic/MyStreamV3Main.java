package ch04applylambda.sub4stream.step3generic;

import ch04applylambda.sub3filtermap.Student;

import java.util.List;

public class MyStreamV3Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("학생1", 100),
                new Student("학생22", 20),
                new Student("학생333", 70),
                new Student("학생444", 10),
                new Student("학생555", 80),
                new Student("학생666", 100)
        );

        // 점수가 80점 이상인 학생의 이름 추출하기
        List<String> result1 = MyStreamV3.of(students)
                .filter(student -> student.getScore() >= 80)
                .map(student -> student.getName())
                .toList();
        System.out.println("result1 = " + result1);

        // 점수가 80점 이상이면서, 이름이 5글자인 학생의 이름을 대문자로 추출
        List<String> result2 = MyStreamV3.of(students)
                .filter(student -> student.getScore() >= 80 && student.getName().length() == 5)
                .map(student -> student.getName().toUpperCase())
                .toList();
        System.out.println("result2 = " + result2);
    }
}