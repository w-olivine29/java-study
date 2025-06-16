package ch27collection.section6set;

import java.util.*;

public class JavaSetMain {
    public static void main(String[] args) {
        // Set <- HashSet <- LinkedHashSet
        // Set <- SortedSet <- TreeSet

        // 타입추론
        run(new HashSet<>()); // 입력 순서보장 x   [99, A, 1, 111, B, C, D, " ", 5]
        run(new LinkedHashSet<>()); // 입력 순서보장 o  [B, A, D, C, " ", 5, 1, 99, 111]
        run(new TreeSet<>());  // 값 오름차순 정렬 (디폴트) [" ", 1, 111, 5, 99, A, B, C, D]

    }

    private static void run(Set<String> set) {
        System.out.println("set.getClass() = " + set.getClass());
        set.add("B");
        set.add("A");
        set.add("D");
        set.add("C");
        set.add("\" \""); //" "
        set.add("5");
        set.add("1");
        set.add("99");
        set.add("111");

        System.out.println("\n=== set 출력 ===");
        System.out.println(set);

        System.out.println("=== iterator 로 출력 ===");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();
    }

    /*
    HashSet - 입력순서 보장 X, 조회 평균 O(1)
    LinkedHashSet - 입력순서 보장 o, 조회 평균 O(1)
    TreeSet - 데이터 값 기준 정렬, 조회 O(log N)

    직접 정의한 클래스를 보관 시
    Hash 자료구조 - hashcode(), equals() 재정의 필수
    TreeSet - 정렬기준 필요 (Comparable, Comparator 인터페이스 구현)
    */


    /* 정렬 순서 참고)
        숫자 '0'~'9' (48~57) < 대문자 'A'~'Z' (65~90) < 소문자 'a'~'z' (97~122)
        문자열은 문자단위로 비교 (왼쪽 -> 오른쪽)

        ex)
        "99" = ['9', '9'] → 아스키코드 57, 57
        "111" = ['1', '1', '1'] → 아스키코드 49, 49, 49

        → '9' (57) > '1' (49)
        → 따라서 "99" > "111"
    */


}
