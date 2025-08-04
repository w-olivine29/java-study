package ch06methodreference.sub2.step3arbitraryobject;

import ch06methodreference.sub2.Person;

import java.util.function.Function;

public class MethodRefEx3 {
    public static void main(String[] args) {

        // 4. 임의 객체의 인스턴스 메서드 참조 (특정 타입의)
        Person person1 = new Person("당나귀");
        Person person2 = new Person("노새");
        Person person3 = new Person("말");

        // 람다
        Function<Person, String> function1 = person -> person.introduceWithNumber();
        System.out.println("person1.introduce = " + function1.apply(person1));
        System.out.println("person2.introduce = " + function1.apply(person2));
        System.out.println("person3.introduce = " + function1.apply(person3));

        System.out.println();
//=============================================================================================
        // 메서드 참조, 타입이 첫 번째 매개변수가 되며 첫 번째 매개변수의 메서드 호출
        // 나머지는 순서대로 매개변수에 전달
        Function<Person, String> function2 = Person::introduceWithNumber; // 타입::인스턴스메서드  (매개변수로 지정한 특정 임의 객체의 인스턴스 메서드 참조)
        System.out.println("person1.introduce = " + function2.apply(person1));
        System.out.println("person2.introduce = " + function2.apply(person2));
        System.out.println("person3.introduce = " + function2.apply(person3));
    }
}

/* 임의 객체의 인스턴스 메서드 참조
특정 타입의 임의 객체의 인스턴스 참조

- Function<T, R> = T(클래스 타입)::인스턴스메서드
    왼쪽에 지정한 클래스를 람다의 첫 번째 매개변수로 사용
    오른쪽에 지정한 인스턴스메서드를 첫번 째 매개변수를 통해 호출


- 특정객체 인스턴스 메서드 참조: 객체명::인스턴스메서드
- 임의객체 인스턴스 메서드 참조: 클래스명::인스턴스메서드
*/