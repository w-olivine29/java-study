package ch27collection.section9iterationsorting.sub2sorting.step2collection;

import ch27collection.section9iterationsorting.sub2sorting.step1array.my.MyUser;
import ch27collection.section9iterationsorting.sub2sorting.step1array.my.NameComparator;

import java.util.Collection;
import java.util.TreeSet;

//TreeSet, TreeMap 처럼 삽입마다 정렬해야하는 클래스는 Comparable, Comparator 구현 필수
public class TreeMain {
    public static void main(String[] args) {

        MyUser user1 = new MyUser("가", 1990);
        MyUser user2 = new MyUser("라", 1970);
        MyUser user3 = new MyUser("나", 1990);
        MyUser user4 = new MyUser("가나", 1990);
        MyUser user5 = new MyUser("가나다", 1900);

//=======================================================================================
        //Tree 자료구조는 삽입 시에 정렬이 바로 일어나기때문에, 무조건 객체 생성 시에 정렬방식이 결정되어야함
        // 기본생성자 호출 -> 다루는 클래스의 Comparable 구현 필수
        // 그 외는 Comparator 객체를 넣어서 생성자 호출

        // Comparable 기본 정렬
        TreeSet<MyUser> treeSet1  = new TreeSet<>();
        treeSet1.add(user1);
        treeSet1.add(user2);
        treeSet1.add(user3);
        treeSet1.add(user4);
        treeSet1.add(user5);
        printCollection(treeSet1);

        //Comparator 정렬
        TreeSet<MyUser> treeSet2  = new TreeSet<>(new NameComparator());
        treeSet2.add(user1);
        treeSet2.add(user2);
        treeSet2.add(user3);
        treeSet2.add(user4);
        treeSet2.add(user5);
        printCollection(treeSet2);


    }

    private static void printCollection(Collection<?> collection) {
        for (Object object : collection) {
            System.out.println(object);
        }
        System.out.println();
    }
}
