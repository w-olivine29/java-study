package ch05javachange.java8.interfacedefaultmethod.after;

public interface Java8Interface {

    String getTime();


    // 인터페이스에서 기본 구현을 제공하는 default 메서드
    // 모든 구현 클래스에서 공통적으로 사용할 수 있으며, 필요 시 재정의(override)도 가능
    default void printTime() {
        System.out.println(getTime());
    }
}
