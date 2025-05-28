package ch20polymorphism.section2.sub1abstract.step3abstract1;

/* 추상클래스
 * 추상메서드가 하나라도 있다면 추상 클래스로 선언해야함
 *
 * 구현부가 없는 불완전한 메서드를 가지고있기때문에 해당 클래스는 본인타입의 인스턴스로 생성불가 (가능한 방법은 익명클래스 참조)
 * -> 상속받는 클래스는 반드시 해당 메서드를 오버라이딩
 * -> 오버라이딩하지않으면 자식클래스도 추상클래스가 되어야함
 * */
public abstract class Bird {

    public abstract void sound(); // 해당 메서드를 반드시 오버라이딩해야함

    public void fly() {
        System.out.println("fly to the sky");
    }
}
