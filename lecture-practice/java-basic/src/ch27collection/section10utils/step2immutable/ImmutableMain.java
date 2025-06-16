package ch27collection.section10utils.step2immutable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {

        //불변 컬렌션 생성
        List<Integer> immutableList = List.of(1,2,3,4);
        System.out.println("immutableList.getClass() = " + immutableList.getClass()); //ImmutableCollections$ListN

//================================================================================================================
        // 불변 컬렉션 -> 가변 컬렉션

        List<Integer> integerList = new ArrayList<>(immutableList);
        integerList.add(1); //가능

        System.out.println("integerList.getClass() = " + integerList.getClass()); //ArrayList

//================================================================================================================
        // 가변 컬렉션 -> 불변 컬렉션

        //ImmutableCollections$List12
        List<List<Integer>> immutableList2 = List.of(integerList);
        System.out.println("immutableList2.getClass() = " + immutableList2.getClass());

        // Collections$UnmodifiableCollection
        Collection<Integer> unmodifiableCollection = Collections.unmodifiableCollection(integerList);
        System.out.println("unmodifiableCollection.getClass() = " + unmodifiableCollection.getClass());


        //Collections$UnmodifiableRandomAccessList
        List<Integer> unmodifiabledList = Collections.unmodifiableList(integerList);
        System.out.println("unmodifiabledList.getClass() = " + unmodifiabledList.getClass());
    }
}
