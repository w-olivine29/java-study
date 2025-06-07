package ch26generic.section1necessity.step1start;

public class BoxMain1 {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.set(10);
        Integer integer = integerBox.get();
        System.out.println("integer = " + integer);

        StringBox stringBox = new StringBox();
        stringBox.set("string");
        String string = stringBox.get();
        System.out.println("string = " + string);
        
        /*
        이후에 Double, Boolean 등을 포함한 다양한 타입의 Box클래스가 필요 시,
        각각 타입별로 계속 xxxBox를 새로 만들어야하는 상황

        역할은 동일하지만, 다루는 타입이 다르다는 이유로
        반복적인 클래스 정의가 필요해지는 비효율적인 구조

        next step)
         그렇다면, 다루는 타입이 달라도 하나의 클래스로 관리할 수는 없을까?
            → Object 타입을 사용하면 가능할지도? (다형성을 활용해보자)
        */
    }
}
