package ch20polymorphism.section2.sub1abstract.step4abstract2;

/* 모든 메서드가 추상메서드인 클래스

 - 인스턴스 생성불가
 - 자식클래스들은 해당클래스의 모든 메서드를 구현(오버라이딩)
 - 주로 다형성을 위해 사용

 -> 부모의 데이터와 기능을 상속받는다기보다, 
 특정 메서드를 규격에 맞추어 구현해야 한다는 제약만 부여받음  ex) move() -> "움직인다"라는 규격에 맞춰서 구현해야함

 -> 인터페이스와 비슷하다
 */
public abstract class Bird {

    public abstract void sound(); // 해당 메서드를 반드시 오버라이딩해야함

    public abstract void fly(); // 해당 메서드를 반드시 오버라이딩해야함
}
