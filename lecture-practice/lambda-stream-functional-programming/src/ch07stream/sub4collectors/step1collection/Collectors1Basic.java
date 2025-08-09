package ch07stream.sub4collectors.step1collection;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {
    public static void main(String[] args) {
        // 기본 기능

        // 수정 가능 리스트 반환  ====================================================================================
        List<String> list = Stream.of("Brie", "Camembert", "Ricotta")
                .collect(Collectors.toList());
        list.add("Mascarpone");
        System.out.println("list = " + list);

        // 수정 불가능 리스트 반환  ====================================================================================
        List<String> unmodifiableList = Stream.of("Brie", "Camembert", "Ricotta")
                .collect(Collectors.toUnmodifiableList()); // 수정 불가능 리스트 반환
        //unmodifiableList.add("Mascarpone"); //UnsupportedOperationException
        System.out.println("unmodifiableList = " + unmodifiableList);

        // Java 16 부터는 .toList()제공 (불변 리스트 반환)
        
        //  Set 반환 ====================================================================================
        Set<String> set = Stream.of("Brie", "Brie", "Cream cheese", "Brie", "Cottage cheese")
                .collect(Collectors.toSet());
        System.out.println("set = " + set); // [Brie, Cream cheese, Cottage cheese]

        //  타입 지정 ====================================================================================
        TreeSet<String> treeSet = Stream.of("Cream cheese", "Ricotta", "Ricotta", "Cottage cheese", "Mascarpone", "Gouda")
                .collect(Collectors.toCollection(TreeSet::new)); //Supplier<C> collectionFactory 구현
        System.out.println("treeSet = " + treeSet); //[Cottage cheese, Cream cheese, Gouda, Mascarpone, Ricotta]
    }
}
