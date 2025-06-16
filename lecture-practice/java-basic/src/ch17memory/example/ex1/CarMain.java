package ch17memory.example.ex1;

// 판매한 차량 수
public class CarMain {
    public static void main(String[] args) {
        Car ioniq7 = new Car("ioniq7");
        Car ev9 = new Car("EV9");
        Car XPlaid = new Car("XPlaid");

        System.out.println("총 판매차량 수: " + Car.getTotalCount());


    }
}
