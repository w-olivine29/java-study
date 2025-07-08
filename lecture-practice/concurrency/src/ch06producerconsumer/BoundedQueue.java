package ch06producerconsumer;

// 버퍼 역할을 하는 큐의 인터페이스
public interface BoundedQueue {

    // 데이터 생산 -> 버퍼에 데이터 보관
    // 생산자 스레드가 호출 -> 데이터 생산
    void put(String data);

    // 버퍼에 보관된 값을 가져감
    // 소비자 스레드가 호출 -> 데이터 소비
    String take();

}
