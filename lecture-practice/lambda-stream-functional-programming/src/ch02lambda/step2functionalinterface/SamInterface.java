package ch02lambda.step2functionalinterface;

// SAM (Single Abstract Method)
// 함수형 인터페이스: 단 하나의 추상메서드를 포함하는 인터페이스

@FunctionalInterface // 하나의 추상 메서드만 포함한다는 것을 보장 (메서드 두개 이상 정의 시 컴파일 에러 발생)
public interface SamInterface {
    void run();
}
