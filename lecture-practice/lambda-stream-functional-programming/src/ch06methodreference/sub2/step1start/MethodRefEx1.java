package ch06methodreference.sub2.step1start;

import ch06methodreference.sub2.Person;

import java.util.function.Supplier;

public class MethodRefEx1 {
    public static void main(String[] args) {

        // 1. 정적 메서드 참조 ===========================================================================
        Supplier<String> staticMethod1 = () -> Person.greeting();
        Supplier<String> staticMethod2 = Person::greeting; // 클래스::메서드

        System.out.println("staticMethod1 = " + staticMethod1.get());
        System.out.println("staticMethod2 = " + staticMethod2.get());
        
        // 2. 특정 객체의 인스턴스 참조 ===========================================================================
        Person person = new Person("당나귀");

        Supplier<String> instanceMethod1 = () -> person.introduceWithNumber();
        Supplier<String> instanceMethod2 = person::introduceWithNumber; // 인스턴스::메서드

        System.out.println("instanceMethod1 = " + instanceMethod1.get());
        System.out.println("instanceMethod2 = " + instanceMethod2.get());
        
        // 3. 생성자 참조 ===========================================================================
        Supplier<Person> newPerson1 = () -> new Person();
        Supplier<Person> newPerson2 = Person::new;

        System.out.println("newPerson1 = " + newPerson1.get());
        System.out.println("newPerson2 = " + newPerson2.get());
    }
}

/*
메서드 참조에서 () 를 사용하지 않는 이유

() 는 메서드를 즉시 호출한다는 의미를 가짐
메서드 참조하는 시점에서는 호출이 아닌, 단순히 메서드 이름으로 해당 메서드를 참조만 한다는 뜻
실제 호출 시점은 함수형 인터페이스를 통해서 이후에 이뤄짐

*/