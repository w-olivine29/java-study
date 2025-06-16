package ch27collection.section9iterationsorting.sub1iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

// default 메서드는 따로 구현 할 필요 x
// Iterable -> 반복할 수 있다 -> Iterator(반복자)를 반환한다
public class MyArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] arr;
    private int size;

    public MyArray() {
        this.arr = new Object[DEFAULT_CAPACITY]; //타입 이레이저 때문에 직접 T타입 배열 생성 x
    }

    public MyArray(int capacity) {
        this.arr = new Object[capacity];
    }


    // 주의) 데이터 추가는 T 타입으로만 가능하게 설계해야함
    public void add(T element) {
        arr[size++] = element;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator();
    }


    // 향상된 for문의 실체
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    // 반복자 객체 생성은 MyArray 내부에서만 필요하므로 클래스는 private
    // Iterator 기능은 외부에서 사용되므로 메서드는 public
    // 외부 클래스의 T를 그대로 사용하므로 제네릭을 다시 선언x
    private class MyArrayIterator implements Iterator<T> {

        private int currentIndex = -1;

        //외부에서 생성자 호출 방지
        private MyArrayIterator() {
        }


        @Override
        public boolean hasNext() {
            return currentIndex < size - 1;
        }

        @Override
        public T next() {
            if (currentIndex >= size - 1) {
                throw new NoSuchElementException();
            }
            return (T) arr[++currentIndex];
        }
    }
}
