package ch27collection.section6set.example;

import java.util.*;

/* 중복제거 & 입력 순서 유지
여러 값이 저장돼있는 배열이 있다.
여기서 중복 값을 제거하고 값을 출력
입력한 순서대로 값을 출력
*/
public class Example2 {
    public static void main(String[] args) {

        // 중복 값 제거 -> Set 자료구조
        // 출력 순서 관계 o -> LinkedHashSet
        // -> LinkedHashSet 사용
        Integer[] intArr = {10, 10, 40, 40, 80, 70, 77, 77, 100};

        LinkedHashSet<Integer> uniqueValues = extractUniqueOrdered(intArr);
        printCollection(uniqueValues);
    }


    private static <E> LinkedHashSet<E> extractUniqueOrdered(E[] arr) {
        return new LinkedHashSet<>(List.of(arr));
    }

    private static void printCollection(Collection<?> collection) {

        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}
