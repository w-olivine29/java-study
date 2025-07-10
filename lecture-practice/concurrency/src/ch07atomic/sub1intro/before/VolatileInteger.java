package ch07atomic.sub1intro.before;

import ch07atomic.sub1intro.IncrementInteger;

public class VolatileInteger implements IncrementInteger {

    volatile private int value;
    @Override
    public void increment() {
        // 공유자원에 원자적이지 않은 연산 사용 시 멀티스레드 상황에 문제발생
        value++; // Non-atomic operation on volatile field 'value'
    }

    @Override
    public int get() {
        return value;
    }
}
