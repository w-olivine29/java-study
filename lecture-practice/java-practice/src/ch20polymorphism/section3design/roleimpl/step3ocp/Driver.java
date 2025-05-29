package ch20polymorphism.section3design.roleimpl.step3ocp;

/* OCP (Open-Closed Principal)

- Open for extension (새로운 기능추가 및 변경사항 발생 시 기존 코드 확장가능)
Car 인터테이스를 도입 -> 새로운 차량(구현체)을 자유롭게 추가 (확장에 열려있다)
Driver(클라이언트) -> Car인터페이스를 통해 추가된 구현체를 자유롭게 호출

- closed for modification (변경에는 닫혀있다)
Car 구현체들을 계속 추가했지만 Driver(클라이언트) 코드 수정 x ->기능 확장 시 기존 클라이언트의 핵심코드는 수정하지 않아도 됨
*/

/* 전략 패턴(Strategy Pattern)
ocp를 구현하는 방식 중 하나
전략패턴은 다양한 전략(알고리즘 등)을 인터페이스로 캡슐화하여,
해당 전략을 사용하는 기존코드(클라이언트) 를 변경하지 않고 기능 확장 or 교체 가능
* */
public class Driver {

    // Car 라는 역할을 의존 (구현체인 Ev9, MX5 등은 알지 못함)
    private Car car;


    // Car 객체를 주입받는다
    public void setCar(Car car) {
        this.car = car;
    }

    // 주입받은 Car 구현체들의 오버라이딩 된 기능 호출
    public void drive() {

        System.out.println("자동차를 운전합니다");
        if (car != null) {
            car.startEngine();
            car.pressAccelerator();
            car.offEngine();
        }
    }
}
