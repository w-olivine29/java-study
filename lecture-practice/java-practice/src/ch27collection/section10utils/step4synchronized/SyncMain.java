package ch27collection.section10utils.step4synchronized;

import java.util.*;

public class SyncMain {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)); // 불변 -> 가변
        System.out.println("class of list: " + list.getClass());

        // 멀티스레드상황에서 동기화 문제가 발생하지 않는 리스트
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println("class of synchronizedList: " + synchronizedList.getClass()); // java.util.Collections$SynchronizedRandomAccessList

    }
}
