package ch06methodreference.sub2.step4apply;

import ch04applylambda.sub4stream.step3generic.MyStreamV3;
import ch06methodreference.sub2.Person;

import java.util.List;

public class MethodRefEx5_Stream {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("당나귀"),
                new Person("노새"),
                new Person("말")
        );

        // 람다 표현식
        List<Integer> result1 = MyStreamV3.of(persons)
                .map(person -> person.introduceWithNumber())
                .map(str -> str.length())
                .toList();

        System.out.println("result1 = " + result1);

        
        // 메서드 참조 (Method Reference)
        // 람다 표현식 대신 메서드 참조를 사용하면 코드 가독성이 향상
        // 특히 파라미터 타입을 명시적으로 확인할 수 있어
        // IDE 없이도 어떤 타입이 전달되는지 쉽게 파악할 수 있다.
        List<Integer> result2 = MyStreamV3.of(persons)
                .map(Person::introduceWithNumber)
                .map(String::length)
                .toList();
        
        System.out.println("result2 = " + result2);

    }
}
