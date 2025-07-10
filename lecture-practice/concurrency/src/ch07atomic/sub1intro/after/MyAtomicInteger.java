package ch07atomic.sub1intro.after;

import ch07atomic.sub1intro.IncrementInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncrementInteger {

    // Integer 말고도 다양한 AtomicXxx 클래스가 존재
    // 내부에 동기화관련 로직이 구현 (락을 사용하는 것은 아님)
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void increment() {
        atomicInteger.incrementAndGet(); // return U.getAndAddInt(this, VALUE, 1) + 1;
    }

    @Override
    public int get() {
        return atomicInteger.get();
    }
}
