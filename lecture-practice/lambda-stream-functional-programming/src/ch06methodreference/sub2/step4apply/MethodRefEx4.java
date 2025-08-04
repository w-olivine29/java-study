package ch06methodreference.sub2.step4apply;

import ch06methodreference.sub2.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("당나귀"),
                new Person("노새"),
                new Person("말")
        );

        List<String> result1 = mapPersonToString(persons, (Person p) -> p.introduceWithNumber());
        List<String> result2 = mapPersonToString(persons, Person::introduceWithNumber); //Person 타입의 임의객체 인스턴스 메서드 참조
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        List<Integer> lengthResult1 = mapStringToInteger(result1, s -> s.length());
        List<Integer> lengthResult2 = mapStringToInteger(result1, String::length); //String 타입의 임의객체 인스턴스 메서드 참조

        System.out.println("lengthResult1 = " + lengthResult1);
        System.out.println("lengthResult2 = " + lengthResult2);
    }
    static List<String> mapPersonToString(List<Person> persons, Function<Person, String> function) {
        List<String> result = new ArrayList<>();
        for(Person person: persons){
            result.add(function.apply(person));
        }
        return result;
    }

    static List<Integer> mapStringToInteger(List<String> strings, Function<String, Integer> function){
        List<Integer> result = new ArrayList<>();
        for(String str: strings){
            result.add(function.apply(str));
        }
        return result;
    }
}
