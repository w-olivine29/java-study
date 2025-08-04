package ch06methodreference.sub2.step4apply;

import ch06methodreference.sub2.Person;

import java.util.function.BiFunction;

// 매개변수 추가
public class MethodRefEx6_MultipleParameters {
    public static void main(String[] args) {
        
        // 임의 객체의 인스턴스 메서드 참조(특정 타입의)
        Person person = new Person("당나귀");
        
        // 람다
        BiFunction<Person, Integer, String> function1 =
                (p, number) -> p.introduceWithNumber(number);

        System.out.println("function1 = " + function1.apply(person, 400));


        // 메서드 참조
        // 임의 객체 인스턴스 메서드 참조는 함수형 인터페이스의 시그니처에 따라
        // 첫번째 인자를 호출 대상 객체
        // 나머지 인자들은 순서대로 해당 메서드의 매개변수로 전달
        BiFunction<Person, Integer, String> function2 = Person::introduceWithNumber;

        System.out.println("function2 = " + function2.apply(person, 400));
    }
}
