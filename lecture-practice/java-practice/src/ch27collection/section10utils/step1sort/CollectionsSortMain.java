package ch27collection.section10utils.step1sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsSortMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(List.of(3, 5, 8, 3, 2, 5, 6, 7, 8, 0));

        System.out.println("before: " + list);

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("최댓값: " + max + "  최솟값: " + min);


        // 요소를 랜덤하게 섞기 (실행할때마다 다름)
        Collections.shuffle(list);
        System.out.println("==== after shuffle ====");
        printCollection(list);


        Collections.sort(list); // list.sort(null) 을 권장
        System.out.println("==== after sort ====");
        printCollection(list);

        Collections.sort(list); // list.sort(null) 을 권장
        System.out.println("==== after sort ====");
        printCollection(list);


        // 현재 위치를 반대로 정렬
        Collections.reverse(list);
        System.out.println("==== after reverse1 ====");
        printCollection(list);


        // 원복
        Collections.reverse(list);
        System.out.println("==== after reverse2 ====");
        printCollection(list);
    }


    private static void printCollection(Collection<?> collection) {
        for (Object object : collection) {
            System.out.println(object);
        }
        System.out.println();
    }
}
