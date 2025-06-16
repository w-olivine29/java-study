package ch27collection.section1arraylist.sub2fromscratch.step2dynamic;

import java.util.Arrays;

//동적 배열 구현
public class MyArrayListV2 {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size;   // 현재 데이터 개수


    public MyArrayListV2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }


    public int size() {
        return size;
    }


    // 용량이 찼다면, 배열길이를 동적으로 변경
    public void add(Object e) {
        if (size >= elementData.length) {
            increaseCapacity();
        }
        elementData[size++] = e;
    }

    private void increaseCapacity() {
        // 새로운 길이의 배열을 생성한 후 복사한 기존 배열내용을 넣는다.
        elementData = Arrays.copyOf(elementData, elementData.length * 2);

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
