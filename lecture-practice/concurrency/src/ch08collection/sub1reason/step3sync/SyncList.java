package ch08collection.sub1reason.step3sync;

import ch08collection.sub1reason.SimpleList;

import java.util.Arrays;

import static util.ThreadUtils.sleep;

/* BasicList + synchronized
이런 식이면 모든 컬렉션을 복사하여 동기화 용으로 새로 구현해야하는 상황,
구현이 변경될때, 모드 곳에서 변경해야함

next step) 기존 코드는 그대로 사용하면서, 동기화가 필요할때만 synchronized 기능을 추가하도록 해보자
    => 프록시 도입
*/
public class SyncList implements SimpleList {

    private static final int DEFAULT_CAPACITY= 5;
    private Object[] elementData;
    private int size = 0;

    public SyncList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object e) {
        elementData[size] = e;
        sleep(100); // 멀티스레드 문제 확인용 코드
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return elementData[index];
    }

    @Override
    public synchronized String toString() {
        return String.format("%s size= %d, capacity= %d",
                Arrays.toString(Arrays.copyOf(elementData, size)), this.size, DEFAULT_CAPACITY);
    }
}

