package ch07stream.sub4collectors.step1collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {
    public static void main(String[] args) {

        // 기본 ====================================================================================
        Map<String, Integer> map1 = Stream.of("Mascarpone", "Cheddar", "Parmesan", "Swiss cheese", "Gouda")
                .collect(Collectors.toMap(
                        name -> name, // Function keyMapper
                        String::length // Function valueMapper
                ));
        System.out.println("map = " + map1); //{Parmesan=8, Cheddar=7, Gouda=5, Mascarpone=10, Swiss cheese=12}


        // 중복 되는 키를 추가 시 ====================================================================================
        // IllegalStateException: Duplicate key
//        Map<String, Integer> map2 = Stream.of("Cheddar", "Cheddar", "Cheddar", "Swiss cheese", "Gouda")
//                .collect(Collectors.toMap(
//                        name -> name, // Function keyMapper
//                        String::length // Function valueMapper
//                ));

        // 키 중복 시 (병합) ====================================================================================
        Map<String, Integer> map3 = Stream.of("Cheddar", "Cheddar", "Cheddar", "Swiss cheese", "Gouda")
                .collect(Collectors.toMap(
                        name -> name, // Function keyMapper
                        String::length, // Function valueMapper

                        // BinaryOperator<U> mergeFunction - key 값 중복 시의 병합 방식 지정
                        (oldValue, newValue) -> oldValue + newValue  //Integer::sum
                ));

        System.out.println("map3 = " + map3); //{Gouda=5, Cheddar=21, Swiss cheese=12}

        // Map 타입 지정 ====================================================================================
        Map<String, Integer> map4 = Stream.of("Mascarpone", "Cheddar", "Parmesan", "Swiss cheese", "Gouda")
                .collect(Collectors.toMap(
                        name -> name, // Function keyMapper
                        String::length,// Function valueMapper
                        Integer::sum, //BinaryOperator<U> mergeFunction
                        LinkedHashMap::new //Supplier<M> mapFactory - 원하는 Map 타입 지정
                ));
        System.out.println("map4 = " + map4); //{Mascarpone=10, Cheddar=7, Parmesan=8, Swiss cheese=12, Gouda=5}
        System.out.println("map4.getClass = " + map4.getClass()); //class java.util.LinkedHashMap
    }
}
