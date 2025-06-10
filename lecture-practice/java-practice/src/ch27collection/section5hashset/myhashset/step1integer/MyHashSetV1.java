package ch27collection.section5hashset.myhashset.step1integer;


import java.util.Arrays;
import java.util.LinkedList;

/* 구현할 메서드 (해시 인덱스를 사용)
- add(value) : 값 추가 (중복 데이터 허용X)
- contains(value): 값이 있는지 확인
- remove(value):값 제거
*/
public class MyHashSetV1 {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;

    private LinkedList<Integer>[] hashSet;
    private int size;
    private int capacity = DEFAULT_INITIAL_CAPACITY;


    public MyHashSetV1() {
        init(capacity);
    }

    public MyHashSetV1(int capacity) {
        this.capacity = capacity;
        init(capacity);
    }

    private void init(int capacity) {
        hashSet = new LinkedList[capacity];
        for (int i = 0; i < hashSet.length; i++) {
            hashSet[i] = new LinkedList<>();
        }
    }


    public boolean add(int value) {
        LinkedList<Integer> elements = this.hashSet[hashIndex(value)];
        if (elements.contains(value)) {
            return false;
        }
        hashSet[hashIndex(value)].add(value);
        size++;
        return true;
    }

    public boolean contains(int value) {
        LinkedList<Integer> elements = this.hashSet[hashIndex(value)];
        return elements.contains(value);
    }


    public boolean remove(int value) {
        LinkedList<Integer> elements = this.hashSet[hashIndex(value)];
        boolean isRemoved = elements.remove(Integer.valueOf(value));//기본타입 int 로 넘기면, index를 받는 메서드 호출

        if (!isRemoved) {
            return false;
        }
        size--;
        return false;
    }

/*  // 내가 구현했던 remove 메서드
    public boolean remove(int value) {
        LinkedList<Integer> elements = this.hashSet[hashIndex(value)];
        int valueIndex = elements.indexOf(value);
        if (valueIndex == -1) {
            return false;
        }
        elements.remove(valueIndex);
        size--;
        return true;
    }*/

    private int hashIndex(int value) {
        return Math.abs(value) % capacity; // 음수값이어도 양수값으로 계산하게끔
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "hashSet=" + Arrays.toString(hashSet) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}

