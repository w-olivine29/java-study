package ch27collection.section5hashset.myhashset.step2object;


import java.util.Arrays;
import java.util.LinkedList;

// 모든 타입을 저장할 수 있는 Set 만들기
public class MyHashSetV2 {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;

    private LinkedList<Object>[] hashSet;
    private int size;
    private int capacity = DEFAULT_INITIAL_CAPACITY;


    public MyHashSetV2() {
        init(capacity);
    }

    public MyHashSetV2(int capacity) {
        this.capacity = capacity;
        init(capacity);
    }

    private void init(int capacity) {
        hashSet = new LinkedList[capacity];
        for (int i = 0; i < hashSet.length; i++) {
            hashSet[i] = new LinkedList<>();
        }
    }


    public boolean add(Object value) {
        LinkedList<Object> elements = this.hashSet[hashIndex(value)];
        if (elements.contains(value)) {
            return false;
        }
        hashSet[hashIndex(value)].add(value);
        size++;
        return true;
    }

    public boolean contains(Object value) {
        LinkedList<Object> elements = this.hashSet[hashIndex(value)];
        return elements.contains(value);
    }


    public boolean remove(Object value) {
        LinkedList<Object> elements = this.hashSet[hashIndex(value)];
        boolean isRemoved = elements.remove(value);

        if (!isRemoved) {
            return false;
        }
        size--;
        return false;
    }


    private int hashIndex(Object value) {
        return Math.abs(value.hashCode()) % capacity; // 음수값이어도 양수값으로 계산하게끔
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV2{" +
                "hashSet=" + Arrays.toString(hashSet) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }


}

