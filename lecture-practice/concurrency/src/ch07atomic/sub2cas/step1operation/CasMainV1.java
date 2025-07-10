package ch07atomic.sub2cas.step1operation;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        // 비교하고 비교한 값이 맞으면 값을 세팅
        boolean result1 = atomicInteger.compareAndSet(0, 1); // 기대하는 값이 0이면 1로 세팅
        System.out.printf("result1= %s, value = %s\n", result1, atomicInteger.get()); //result1= true, value = 1

        boolean result2 = atomicInteger.compareAndSet(0, 1); // 기대하는 값이 0이면 1로 세팅
        System.out.printf("result2= %s, value = %s\n", result2, atomicInteger.get()); //result2= false, value = 1


/*
해당 메서드는 원자적으로 실행 (CAS 연산)
 compareAndSet(0, 1); // 기대하는 값이 0이면 1로 세팅
 CAS 연산은 메모리에 있는 값이 기대하는 값이라면 원하는 값으로 변경

 과정)
 1. 메인 메모리에 있는 값 확인
 2. 해당 값이 기대하는 값이라면 원하는 값으로 변경
 -> 명령어가 두개인데, 이게 원자적으로 실행..???


CPU가 원자적 연산으로 만들어준다.

CAS 연산)
 원자적이지 않은 두 개의 연산을 CPU "하드웨어 차원"에서 하나의 원자적인 연산으로 묶어서 제공하는 기능 (소프트웨어 제공 x, 하드웨어 제공 o)
 두 연산을 묶어서 하나의 원자적인 명령으로 만듬 -> 중간에 다른 스레드 개입불가

cpu가 물리적으로 값을 확인한고, 확인하는 순간 다른 스레드들이 이 값을 못 바꾸게 막는다. (아주 찰나의 순간)

    next step) 이 기능이 어떻게 락을 일부 대체 가능하다는 것인지?
*/
    }
}
