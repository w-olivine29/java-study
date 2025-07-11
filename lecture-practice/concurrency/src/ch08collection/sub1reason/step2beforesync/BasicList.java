package ch08collection.sub1reason.step2beforesync;

import ch08collection.sub1reason.SimpleList;

import java.util.Arrays;

import static util.ThreadUtils.sleep;

public class BasicList implements SimpleList {

    private static final int DEFAULT_CAPACITY= 5;
    private Object[] elementData;
    private int size = 0;

    public BasicList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object e) {
        elementData[size] = e;
        sleep(100); // 멀티스레드 문제 확인용 코드
        size++;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public String toString() {
        return String.format("%s size= %d, capacity= %d",
                Arrays.toString(Arrays.copyOf(elementData, size)), this.size, DEFAULT_CAPACITY);
    }
}
