package ch27collection.section3list.sub1abstract.step1interface;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] dataArr;

    private int size;

    public MyArrayList() {
        this.dataArr = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.dataArr = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if (size >= dataArr.length) {
            increaseCapacity();
        }
        dataArr[size++] = e;
    }

    @Override
    public void add(int index, E e) {
        if (size >= dataArr.length) {
            increaseCapacity();
        }
        shiftRight(index);
        dataArr[index] = e;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        E oldValue = get(index);
        dataArr[index] = e;
        return oldValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index, E e) {
        E removedValue = (E) dataArr[index];
        shiftLeft(index);
        size--;
        return removedValue;
    }


    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) dataArr[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (dataArr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        dataArr = Arrays.copyOf(dataArr, (int) Math.ceil(dataArr.length * 1.5));
    }

    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            dataArr[i] = dataArr[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size-1; i++) {
            dataArr[i] = dataArr[i + 1];
        }
    }
}
