package ch26generic.section1necessity.step3generic;

public class GenericBox<T> { // T는 타입 매개변수라 보면 된다

    // 객체 생성 시점에 T의 타입 결정
    private T value;

    // 클래스 내부에 T 타입 사용
    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
