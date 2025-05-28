package ch20polymorphism.section2.sub2interface.step2multi;

public class Child implements InterfaceA, InterfaceB {

    @Override
    public void methodA() {
        System.out.println("Child.methodA");
    }

    @Override
    public void methodB() {
        System.out.println("Child.methodB");
    }

    @Override
    public void methodCommon() {
        System.out.println("common");
    }
    /*
    InterfaceA, InterfaceB 에 둘다 있는 동일 시그니처의 메서드이지만
    다형성 참조를 하더라도 자식클래스에서 오버라이딩된 것이 우선시 되기 때문에
    자식에서 오버라이딩한 메서드로 호출됨

    인터페이스의 메서드는 public abstract 이 기본이기때문에 오버라이딩이 필수
    추상클래스가 다중상속을 한다면 동일한 시그니처의 메서드가 있을 때 어떤 부모클래스의 메서드를 호출해야하지? 라는 모호성이 없음

    동일한 시그니처의 추상 메서드가 여러 인터페이스에 정의되어 있더라도,
    구현 클래스에서 단 한 번 오버라이딩하면 되므로 충돌이 발생하지 않음
    그러므로 인터페이스의 다중구현은 충돌문제가 없음
    * */

}
