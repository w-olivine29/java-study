package ch08collection.sub2collection.step2concurrent;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(1);
        copySet.add(2);
        copySet.add(3);
        System.out.println("copySet = " + copySet); // 순서 보장 x

        Set<Object> skipSet = new ConcurrentSkipListSet<>(); //ConcurrentSkipListSet(Comparator<? super E> comparator)
        skipSet.add(3);
        skipSet.add(2);
        skipSet.add(1);
        System.out.println("skipSet = " + skipSet); //skipSet = [1, 2, 3]  가지고 있는 조건에 따라 정렬

    }
}
