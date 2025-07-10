package ch07atomic.sub2cas.step1operation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// AtomicInteger가 제공하는 incrementAndGet()  내부 로직을 이해하기 위한 간단한 구현 - 멀티스레드 환경
public class CasMainV3 {
    private static int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };


        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName() + " resultValue: " + result);

    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {

        int getValue;
        boolean result;

        // 정상적으로 연산에 성공할 때까지 반복
        do {
            getValue = atomicInteger.get(); // 조회
            sleep(100); // 스레드 동시 실행 시나리오를 보장하기 위함

            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1); // 현 스레드가 조회했던 시점의 값과 동일한 상태면 변경 (여기서 CAS 연산)
            log("result: " + result);
        } while (!result); // 동일하지않다면 다른 스레드가 값을 중간에 변경한 것이므로, 다시 위 과정 반복


//        // get()으로 바로 반환하지 않는 이유: 다른 스레드가 값을 변경할 수 있기때문
//        return atomicInteger.get();

        return getValue + 1; // 현 스레드가 조회, 증가시켰던 값을 반환해주는 것이 목적
    }
}

/* 순서보장 x

start value = 0
59.149 [ Thread-0] getValue: 0
59.149 [ Thread-1] getValue: 0
59.151 [ Thread-0] result: true // 스레드0이 성공적으로 값 변경

59.151 [ Thread-1] result: false // 스레드1이 조회했던 값을 수정하기 전에 스레드0이 값을 변경했기때문
59.151 [ Thread-1] getValue: 1 // 다시 시도
59.151 [ Thread-1] result: true // 중간에 끼어드는 다른 스레드가 없는 상황
AtomicInteger resultValue: 2

CAS)
락을 걸지 않고서도 현 스레드가 값을 바꿀 때까지 유지되도록 한다.
다른 스레드가 값을 먼저 증가해서 문제가 발생하는 경우 루프를 돌며 재시도 하는 방식 사용 (스레드 충돌이 발생할 때마다 반복 재시도)
-> 락 없이 데이터를 안전하게 변경 가능

스레드가 락 획득을 위해 대기하지 않기 때문에 
락 사용 방식에 비해 대기 시간, 오버헤드가 비교적 감소하는 장점

but 충돌이 빈번하게 일어나는 환경에서는 성능 문제 발생
실패, 재시도를 하면서 계속 반복문을 돌게된다. -> CPU 자원을 많이 소모

간단한 CPU 연산에서는 락 보다는 CAS 사용이 효과적


Lock & CAS 방식 비교
Lock 방식
    - 비관적 접근법 (입구가 하나고, 들어가면 닫는다고 보면 된다)
    - 데이터에 접근 전에 락 획득
    - 다른 스레드 접근 막음

CAS 방식
    - "낙관적 접근법"
    - 락 없이 바로 데이터 접근가능
    - 충돌 발생 시에 재시도
    - 대부분의 경우 충돌이 없을 것으로 가정
*/