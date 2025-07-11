package ch08collection.sub1reason.step4proxy;

import ch08collection.sub1reason.SimpleList;

/* 프록시 역할을 하는 클래스
 synchronized 만 걸고, 실제 호출해야하는 원본 대상(target)을 호출
 클라이언트 -> SyncProxyList(프록시) -> SimpleList(서버)
 클라이언트 입장에서는 프록시는 타겟과 동일하게 생겼고, 호출할 메서드도 동일
 
 원본 코드를 건드리지 않고, 프록시를 통해 동기화 기능 적용
 이후에 같은 인터페이스의 구현체도 프록시기능 적용 가능
*/
public class SyncProxyList implements SimpleList {

    private SimpleList target;


    public SyncProxyList(SimpleList target) {
        this.target = target;
    }

    // 1. lock 획득
    @Override
    public synchronized int size() {

        // 2. 원본 메서드 호출
        return target.size();
        // 3. 원본 메서드 반납

        // 4. lock 반납
    }

    @Override
    public synchronized void add(Object e) {
        target.add(e);
    }

    @Override
    public synchronized Object get(int index) {
        return target.get(index);
    }

    @Override
    public String toString() {
        return target.toString() + "  by " + this.getClass().getSimpleName();
    }
}
