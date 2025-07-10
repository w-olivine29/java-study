package ch07atomic.sub2cas.step1operation;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

// AtomicInteger가 제공하는 incrementAndGet()  내부 로직을 이해하기 위한 간단한 구현 - 단일스레드 환경
public class CasMainV2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        int resultValue1 = incrementAndGet(atomicInteger);
        System.out.println("resultValue1 = " + resultValue1);

        int resultValue2 = incrementAndGet(atomicInteger);
        System.out.println("resultValue2 = " + resultValue2);


    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {

        int getValue;
        boolean result;
        
        // 정상적으로 연산에 성공할 때까지 반복
        do {
            getValue = atomicInteger.get(); // 조회
            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1); // 현 스레드가 조회했던 시점의 값과 동일한 상태면 변경 (여기서 CAS 연산)
            log("result: " + result);
        } while (!result); // 동일하지않다면 다른 스레드가 값을 중간에 변경한 것이므로, 다시 위 과정 반복

        return getValue + 1;
    }
}
