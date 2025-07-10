package ch07atomic.sub1intro;

import ch07atomic.sub1intro.after.MyAtomicInteger;
import ch07atomic.sub1intro.before.BasicInteger;
import ch07atomic.sub1intro.before.SyncInteger;
import ch07atomic.sub1intro.before.VolatileInteger;

public class IncrementPerformanceMain {

    public static final long COUNT = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {

        long startMs = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName() + ": ms=" + (endMs - startMs));
    }

/* 결과 보장x
BasicInteger: ms=5
VolatileInteger: ms=673
SyncInteger: ms=1612
MyAtomicInteger: ms=564

BasicInteger
 - cpu 캐시 적극 사용
 - 단일스레드 사용 시 효율적
 - 멀티스레드 상황에서는 사용불가 (안전한 임계 영역 x, volatile 사용x)

VolatileInteger
 - CPU 캐시 접근 x -> 메인 메모리 접근
 - 단일 스레드가 사용하기에 BasicInteger 보다 느림
 - 멀티스레드 상황에서는 사용불가 (안전한 임계 영역 x)

SyncInteger
 - synchronized 사용한 안전한 임계 영역 -> 멀티 스레드에서 안전하게 사용
  - MyAtomicInteger 보다 성능이 느림

MyAtomicInteger
  - 자바가 제공하는 AtomicInteger 클래스 사용
  - 멀티스레드 상황에서 안전하게 사용
  - synchronized, ReentrantLock 을 사용하는 것보다 1.5 ~ 2배 정도의 성능  
     - AtomicInteger 가 제공하는 incrementAndGet() 은 락 사용하지 않으면서 원자적 연산을 만들어내기 때문
*/
}
