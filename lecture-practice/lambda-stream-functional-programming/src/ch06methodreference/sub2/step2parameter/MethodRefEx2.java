package ch06methodreference.sub2.step2parameter;

import ch06methodreference.sub2.Person;

import java.util.function.Function;

public class MethodRefEx2 {
    public static void main(String[] args) {

        // 1. 정적 메서드 참조 ===========================================================================
        Function<String, String> staticMethod1 = name -> Person.greetingWithNames(name);
        Function<String, String> staticMethod2 = Person::greetingWithNames; // 클래스::메서드

        System.out.println("staticMethod1 = " + staticMethod1.apply("당나귀"));
        System.out.println("staticMethod2 = " + staticMethod2.apply("당나귀"));
        
        // 2. 특정 객체의 인스턴스 참조 ===========================================================================
        Person person = new Person("당나귀");

        Function<Integer, String> instanceMethod1 = number -> person.introduceWithNumber(number);
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;  // 인스턴스::메서드

        System.out.println("instanceMethod1 = " + instanceMethod1.apply(400));
        System.out.println("instanceMethod2 = " + instanceMethod2.apply(400));
        
        // 3. 생성자 참조 ===========================================================================
        Function<String,Person> newPerson1 = (name) -> new Person(name);
        Function<String,Person> newPerson2 = Person::new;

        System.out.println("newPerson1 = " + newPerson1.apply("당나귀"));
        System.out.println("newPerson2 = " + newPerson2.apply("당나귀"));
    }
}

/*
메서드 참조에서는 매개변수 생략 (매개변수가 여러개라면 순서대로 전달)

함수형 인터페이스의 시그니처(매개변수와 반환 타입)가 이미 정해져있고,
컴파일러가 그 시그니처를 바탕으로 메서드 참조와 연결해주기때문에,
명시적으로 매개변수를 작성하지 않아도 자동으로 추론되어 호출
*/