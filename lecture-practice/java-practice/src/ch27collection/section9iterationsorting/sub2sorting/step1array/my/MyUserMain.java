package ch27collection.section9iterationsorting.sub2sorting.step1array.my;

import java.util.Arrays;

public class MyUserMain {
    public static void main(String[] args) {
        MyUser user1 = new MyUser("가", 1990);
        MyUser user2 = new MyUser("라", 1970);
        MyUser user3 = new MyUser("나", 1990);
        MyUser user4 = new MyUser("가나", 1990);
        MyUser user5 = new MyUser("가나다", 1900);

        MyUser[] myUsers = {user1, user2, user3, user4, user5};
        printArr(myUsers);

//====================================================================================

        // 기본 정렬
        Arrays.sort(myUsers);  // 기본 정렬의 기준은 Comparable<MyUser>의 compareTo
        printArr(myUsers);

//====================================================================================
        // Comparator - Comparator를 같이 넘겨주면 객체가 가진 Comparable 를 무시
        Arrays.sort(myUsers, new NameComparator());
        printArr(myUsers);

        Arrays.sort(myUsers, new NameComparator().reversed());
        printArr(myUsers);

        // (Comparable구현 X) & (Comparator 제공X) -> 런타임 오류
    }


    private static <T> void printArr(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
        System.out.println();
    }
}
