package ch04applylambda.sub4stream.step4innerloop;

import ch04applylambda.sub3filtermap.Student;

import java.util.List;

public class MyStreamLoopMain {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("학생1", 100),
                new Student("학생22", 20),
                new Student("학생333", 70),
                new Student("학생444", 10),
                new Student("학생555", 80),
                new Student("학생666", 100)
        );

        List<String> result = MyStreamV4.of(students)
                .filter(student -> student.getScore() >= 80)
                .map(student -> student.getName())
                .toList();
        System.out.println("result = " + result);

        // 외부 반복
        for (String name : result) {
            System.out.println("name = " + name);
        }
        
        // 내부 반복
        // 직접 반복 제어문을 작성하지 않고, 반복 처리를 스트림 내부에 위임
        // 스트림 내부에서 요소들을 순회하고, 개발자는 처리 로직(람다)만 정의해주면 됨
        // 선언형 프로그래밍 적용 가능
        MyStreamV4.of(students)
                .filter(student -> student.getScore() >= 80)
                .map(student -> student.getName())
                .forEach(name -> System.out.println(name));
    }
}

/* 내부반복 vs 외부반복 선택

외부 반복 선택
- 단순히 한, 두줄 수행만 필요한 경우
- 반복 제어에 대한 복잡하고 세밀한 조정이 필요한 경우
*/