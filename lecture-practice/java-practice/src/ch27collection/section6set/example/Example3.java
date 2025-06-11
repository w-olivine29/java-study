package ch27collection.section6set.example;

import java.util.*;

/* 중복제거 & 데이터의 값 순서
여러 값이 저장돼있는 배열이 있다.
여기서 중복 값을 제거하고 값을 출력
데이터의 값 순서로 출력
*/
public class Example3 {
    public static void main(String[] args) {

        // 중복 값 제거 -> Set 자료구조
        // 데이터의 값 순서출력 -> TreeSet
        // -> TreeSet 사용
        Integer[] intArr = {10, 10, 40, 40, 80, 70, 77, 77, 100};

        TreeSet<Integer> uniqueValues = extractUniqueSorted(intArr);
        printCollection(uniqueValues);
    }


    private static <E> TreeSet<E> extractUniqueSorted(E[] arr) {
        return new TreeSet<>(List.of(arr));
    }

    private static void printCollection(Collection<?> collection) {

        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}
