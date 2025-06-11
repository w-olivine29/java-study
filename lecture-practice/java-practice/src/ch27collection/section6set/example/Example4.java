package ch27collection.section6set.example;

import java.util.*;

/* 합집합 & 교집합 & 차집합
- 두 개의 숫자 집합 제공
- 두 집합의 합집합, 교집합, 차집합 구하기 (출력 순서 관계 x)
*/
public class Example4 {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5, 7, 8));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7, 1, 3, 9)); //만약 Set.of() 로 생성시, 중복값 넣으면  IllegalArgumentException

        // 합집합
        System.out.println("getUnionSet(set1,set2) = " + getUnionSet(set1, set2));
        System.out.println("getUnionSet(set2,set1) = " + getUnionSet(set2, set1));

        // 교집합
        System.out.println("getIntersectionSet(set1, set2) = " + getIntersectionSet(set1, set2));
        System.out.println("getIntersectionSet(set2, set1) = " + getIntersectionSet(set2, set1));

        // 차집합 (set1 - set2)
        System.out.println("getDifferenceSet(set1, set2) = " + getDifferenceSet(set1, set2));
        // 차집합 (set2 - set1)
        System.out.println("getDifferenceSet(set2, set1) = " + getDifferenceSet(set2, set1));
    }


    private static <E> Set<E> getUnionSet(Set<E> set1, Set<E> set2) {
        Set<E> resultSet = new HashSet<>(set1);
        resultSet.addAll(set2); // set 자료구조는 중복허용 x

        return resultSet;
    }


    private static <E> Set<E> getIntersectionSet(Set<E> set1, Set<E> set2) {
        Set<E> resultSet = new HashSet<>(set1);
        resultSet.retainAll(set2); // 인자값으로 넘긴 컬렉션의 값에 해당되는 값만 유지하고, 나머지 삭제

        return resultSet;
    }

    private static <E>Set<E> getDifferenceSet(Set<E> set1, Set<E> set2) {
        Set<E> resultSet = new HashSet<>(set1);
        resultSet.removeAll(set2);

        return resultSet;
    }


}
