package ch27collection.section1arraylist.sub2fromscratch.step1start;

import java.util.Arrays;

public class MyArrayListV1 {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size;   // 현재 데이터 개수


    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV1(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }


    public int size() {
        return size;
    }


    public void add(Object e) {
        elementData[size++] = e;
    }


    // 조회 기능
    public Object get(int index) {
        return elementData[index];
    }


    // 값 세팅 후 기존값 반홤
    public Object set(int index, Object e) {
        Object oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    // 검색 기능
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == e) {
                return i;
            }
        }
        return -1;
    }


    // 현재 들어있는 데이터까지만 출력
    @Override
    public String toString() {

        return String.format("%s, size: %d, capacity: %d",
                Arrays.toString(Arrays.copyOf(elementData, size)), size, elementData.length);
    }
}
