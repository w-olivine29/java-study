package ch21lang.section1obejct.sub2polymorphism;

public class ObjectPolyMain {
    public static void main(String[] args) {
        Car car = new Car();
        Cat cat = new Cat();

        action(car);
        action(cat);

    }

    private static void action(Object obj) {
        // Object 타입으로 복사해왔기때문에, 해당 메서드들 호출 위해선 다운캐스팅
        if (obj instanceof Car car) {
            car.move();
        } else if (obj instanceof Cat cat) {
            cat.sound();
        }
    }
}
