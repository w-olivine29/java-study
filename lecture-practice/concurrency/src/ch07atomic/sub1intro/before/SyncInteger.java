package ch07atomic.sub1intro.before;

import ch07atomic.sub1intro.IncrementInteger;

public class SyncInteger implements IncrementInteger {

    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int get() {
        return value;
    }
}
