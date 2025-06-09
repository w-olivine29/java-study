package ch27collection.section1arraylist.sub2fromscratch.step3addmethod;


import java.util.Arrays;

/* 기능 추가
    - add(Index, 데이터)
        원하는 index 위치에 데이터 추가
    - remove(Index)
        원하는 index 위치의 데이터 삭제
 */
public class MyArrayListV3 {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size;   // 현재 데이터 개수


    public MyArrayListV3() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity) {
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

    public void add(int index, Object e) {
        if (size >= elementData.length) {
            increaseCapacity();
        }

        // 추가 전 기존 데이터 오른쪽으로 이동필요
        shiftRightFrom(index); //O(n)

        elementData[index] = e;
        size++;
    }

    public Object remove(int index) {
        Object oldValue = elementData[index];
        shiftLeftFrom(index); //O(n)
        size--;

        return oldValue;
    }

    
    // 마지막부터 index 까지 오른쪽으로 밀기
    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }
    
    // 코드 추가 요소의 index부터 마지막까지 왼쪽으로 밀기
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        // 처음 구현했던 코드
//        for (int i = index + 1; i < size; i++) {
//            elementData[i - 1] = elementData[i];
//        }
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
