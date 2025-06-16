package ch20polymorphism.section3design.roleimpl.step2;


// 계속 새로운 자동차를 추가하게되면 클라이언트인 Driver의 코드 변경량이 점점 많아질 것이다.
public class Driver {

    // Driver & Ev9, MX5Car는 객체의존관계 (해당 클래스들을 직접적으로 참조하고 있음)
    private EV9Car ev9Car;
    private MX5Car mx5Car;


    // 메서드를 통해 EV9Car 이라는 객체의 의존관계 주입
    public void setEv9Car(EV9Car ev9Car) {
        this.ev9Car = ev9Car;
    }

    // 메서드를 통해 MX5Car 이라는 객체의 의존관계 주입
    public void setMx5Car(MX5Car mx5Car) {
        this.mx5Car = mx5Car;
    }

    // 주입받은 자동차의 기능을 호출
    public void drive() {

        // 의존관계 추가 ->  조건문 추가
        System.out.println("자동차를 운전합니다");
        if (ev9Car != null) {
            ev9Car.startEngine();
            ev9Car.pressAccelerator();
            ev9Car.offEngine();

        }
        if (mx5Car != null) {
            mx5Car.startEngine();
            mx5Car.pressAccelerator();
            mx5Car.offEngine();
        }
        
    }
}
