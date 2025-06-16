package ch20polymorphism.section3design.roleimpl.step1start;


public class Driver {

    // Driver 와 Ev9는 객체의존관계 (Driver는 Ev9이라는 클래스를 직접적으로 참조하고 있음)
    private EV9Car ev9Car;

    // 메서드를 통해 Ev9 이라는 객체의 의존관계 주입
    public void setEv9Car(EV9Car ev9Car) {
        this.ev9Car = ev9Car;
    }

    // 주입받은 Ev9의 기능을 호출
    public void drive() {
        System.out.println("자동차를 운전합니다");
        ev9Car.startEngine();
        ev9Car.pressAccelerator();
        ev9Car.offEngine();
    }
}
