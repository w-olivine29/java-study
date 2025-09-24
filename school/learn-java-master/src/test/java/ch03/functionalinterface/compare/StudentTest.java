package ch03.functionalinterface.compare;

import net.datafaker.Faker;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@TestMethodOrder(value = MethodOrderer.MethodName.class) // 테스트 메서드 실행 순서 지정 (단순 실습용 세팅)
class StudentTest {
    private final Faker faker = new Faker();

    // 객체 생성용 Supplier (랜덤 값 세팅 - 이름,점수)
    private final Supplier<Student> getStudent =
            () -> new Student(faker.name().fullName(), faker.number().numberBetween(0, 100));


    private final Supplier<List<Student>> getStudents = () ->
            IntStream.range(0, 20)
                    .mapToObj(i -> getStudent.get())
                    .collect(Collectors.toCollection(ArrayList::new)); //toList() 는 불변리스트로 반환하기때문에 테스트 활용에 애로사항이 있음

/*  테스트 데이터 준비
    - 객체를 매번 new로 생성하고 값을 직접 지정하면 반복적이고 비효율적임
    - 또한 필드가 변경될 때마다 테스트 코드 수정이 많이 필요해 유지보수가 어려움
    - Faker와 Supplier를 사용해 랜덤 데이터를 생성하면 테스트가 더 동적이고 유연해짐
    - 이런 방식은 테스트용 객체 세팅(픽스처)을 자동화하는 일반적인 패턴임
    
    
      ※ 픽스처(Fixture): 테스트 실행 전에 미리 준비해두는 고정된 상태나 데이터 세트
      ※ Faker : 가짜 데이터를 랜덤하게 자동으로 랜덤하게 생성해주는 라이브러리 중 하나 (주로 테스트 코드, 샘플 데이터, 시뮬레이션에서 많이 사용)
*/

    @Test
    void testComparable() {
        Student student1 = getStudent.get();
        Student student2 = getStudent.get();

        System.out.println(student1 + " vs " + student2);
        System.out.println(student1.compareTo(student2));
    }

    @Test
    void testComparableSort() {
        List<Student> students = getStudents.get();
        System.out.println("=== Before Sort ===");
        students.forEach(System.out::println);

        System.out.println("=== After Sort ===");
        students.sort(Student::compareTo);
        students.forEach(System.out::println);
    }

    @Test
    void testComparableReverseSort() {
        List<Student> students = getStudents.get();
        System.out.println("=== Before Sort ===");
        students.forEach(System.out::println);

        System.out.println("=== After Sort ===");
        students.sort(Collections.reverseOrder());
        students.forEach(System.out::println);
    }

    @Test
    void testComparator() {
        Student student1 = getStudent.get();
        Student student2 = getStudent.get();

        System.out.println(student1 + " vs " + student2);
        System.out.println(new NameComparator().compare(student1, student2)); // 문자의 사이 간격 값 반환 (아스키코드 기준)
    }

    @Test
    void testComparatorSort() {
        List<Student> students = getStudents.get();
        System.out.println("=== Before Sort ===");
        students.forEach(System.out::println);

        System.out.println("=== After Sort ===");
        students.sort(new NameComparator());
        students.forEach(System.out::println);
    }

    @Test
    void testComparatorReverseSort() {
        List<Student> students = getStudents.get();
        System.out.println("=== Before Sort ===");
        students.forEach(System.out::println);

        System.out.println("=== After Sort ===");
        students.sort(new NameComparator().reversed());
        students.forEach(System.out::println);
    }
}
