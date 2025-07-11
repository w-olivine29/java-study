package ch08collection.sub1reason.step4proxy;


import ch08collection.sub1reason.SimpleList;
import ch08collection.sub1reason.step2beforesync.BasicList;

import static util.MyLogger.log;

public class SimpleListMainV4 {
    public static void main(String[] args) throws InterruptedException {

        BasicList basicList = new BasicList(); // 동기화 적용이 안된 원본 코드
        SyncProxyList proxyList = new SyncProxyList(basicList); // 프록시 적용
        test(proxyList);

    }

    // 리스트 종류에 따른 멀티스레드 환경 동시성 테스트
    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());
        
        // A를 리스트에 저장하는 로직
        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1: list.add(A)");
            }
        };
        
        // B를 리스트에 저장하는 로직
        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2: list.add(B)");
            }
        };

        Thread thread1 = new Thread(addA, "Thread-1");
        Thread thread2 = new Thread(addB, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log(list);
    }
}

/* 순서보장 x

    28.409 [     main] SyncProxyList
    28.514 [ Thread-1] Thread-1: list.add(A)
    28.623 [ Thread-2] Thread-2: list.add(B)
    28.623 [     main] [A, B] size= 2, capacity= 5  by SyncProxyList

*/


/* 프록시 패턴
 
 객체지향 디자인 패턴 중 하나
 어떤 객체에 대한 접근을 제어하기 위해, 그 객체의 대리인 or 인터페이스 역할을 하는 객체를 제공하는 패턴
 프록시 객체는 실제 타겟 객체에 대한 참조 유지, 그 객체에 접근하거나 행동 수행하기 전, 추가적인 처리 가능
 
주요목적
- 접근 제어
    실제 객체에 대한 접근 제한 or 통제 가능
- 성능 향상
    실제 객체의 생성을 지연 or 캐싱 -> 성능 최적화 가능
- 부가 기능 제공
    실제 객체에 추가적인 기능(로깅, 인증, 동기화 등)을 투명하게 제공 가능
    
스프링의 AOP 기능은 프록시 패턴을 극한으로 적용하는 예
*/