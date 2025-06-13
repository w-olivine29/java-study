package ch27collection.section9iterationsorting.sub2sorting.step2collection;

import ch27collection.section9iterationsorting.sub2sorting.step1array.my.MyUser;
import ch27collection.section9iterationsorting.sub2sorting.step1array.my.NameComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//순서가 있는 자료구조에 사용할 수 있음
public class OrderCollectionMain {
    public static void main(String[] args) {

        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser("가", 1990));
        userList.add(new MyUser("라", 1970));
        userList.add(new MyUser("나", 1990));
        userList.add(new MyUser("가나", 1990));
        userList.add(new MyUser("가나다", 1900));


//============================================================================================

        //Collections (Arrays 처럼 유틸클래스)
        Collections.sort(userList);
        printCollection(userList);

        Collections.sort(userList, new NameComparator());
        printCollection(userList);

//==========================================================================================
    // 객체 스스로 정렬메서드를 사용하는 것이 조금 더 객체지향적(권장)

        //Comparable 기본 정렬
        userList.sort(null); // Comparator를  넣지 않으면 Comparable 의 compareTo 정렬사용
        printCollection(userList);

        // Comparator 정렬
        userList.sort(new NameComparator());
        printCollection(userList);

        userList.sort(new NameComparator().reversed());
        printCollection(userList);


    }

    private static void printCollection(Collection<?> collection) {
        for (Object object : collection) {
            System.out.println(object);
        }
        System.out.println();
    }
}
