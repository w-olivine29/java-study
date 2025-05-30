package ch21lang.section1obejct.sub3array;

public class ObjectPolyMain {
    public static void main(String[] args) {
        Car car = new Car();
        Cat cat = new Cat();
        Object obj = new Object();

        Object[] objects = {car, cat, obj};
        printSize(objects);
    }

    private static void printSize(Object[] objects) {
        System.out.println("전달된 객체의 수: " + objects.length);
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
