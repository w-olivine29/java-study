package ch27collection.section9iterationsorting.sub1iteration;

import java.util.*;

public class JavaIterableMain {
    public static void main(String[] args) {
        
        // Collection은 Iterable를 상속 -> Iterator 반환할 수 있음
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
        printIterator(list.iterator());  //ArrayList$Itr
        printForEach(list);

        Set<Integer> hashSet = new HashSet<>(Set.of(1,2,3,4,5));
        printIterator(hashSet.iterator()); //HashMap$KeyIterator
        printForEach(hashSet);
    }

    private static void printIterator(Iterator<?> iterator) {
        System.out.println("iterator.getClass() = " + iterator.getClass());
        // 자료구조별로 자신만의 Iterator를 반환하는 것을 볼 수 있음

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    // Iterable <- Collection <- List,Set,Queue ..
    // 향상된 for문을 사용할 수 있는 조건 = Iterable 구현
    private static void printForEach(Iterable<?> iterable) {

        System.out.println("iterable.getClass() = "+ iterable.getClass());
        for (Object object : iterable) {
            System.out.println("object = " + object);
        }
        System.out.println();
    }


    /* Iterator 디자인 패턴
    컬렉션의 내부 구조를 노출하지 않고, 그 안의 요소들을 하나씩 순차적으로 접근할 수 있게 해주는 패턴

    - 다양한 컬렉션에 대해 일관된 순회 방법 제공
    - 반복 기능을 별도의 객체(Iterator)에 위임
    */
}
