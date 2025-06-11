package ch27collection.section6set.example;

import java.util.*;

/* 중복제거
여러 값이 저장돼있는 배열이 있다.
여기서 중복 값을 제거하고 값을 출력한다. (출력 순서는 관계 x)
*/
public class Example1 {
    public static void main(String[] args) {

        // 중복 값 제거 -> Set 자료구조
        // 출력 순서 관계 x -> Hash 자료구조
        // -> HashSet 사용
        Integer[] intArr = {10, 10, 40, 40, 80, 70, 77, 77, 100};

        HashSet<Integer> uniqueValues = extractUniqueValues(intArr);
        printCollection(uniqueValues);
    }

    private static <E> HashSet<E> extractUniqueValues(E[] arr) {
        return new HashSet<>(List.of(arr));
    }

    private static void printCollection(Collection<?> collection) {

        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}
