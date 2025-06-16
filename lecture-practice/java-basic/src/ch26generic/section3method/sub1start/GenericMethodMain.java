package ch26generic.section3method.sub1start;

public class GenericMethodMain {
    public static void main(String[] args) {

        Integer integer = 10;

        // 제네릭 메서드 X -> 반환타입 다운캐스팅 필요
        Object integerObject = GenericMethod.objMethod(integer);
        Integer result = (Integer) integerObject;

        // 제네릭 메서드는 메서드를 호출하기 직전에 타입결정

        //타입 인자 명시적 전달
        Integer result2 = GenericMethod.<Integer>genericMethod(integer);
        Integer result3 = GenericMethod.<Integer>numberMethod(10);


        // 타입 인자 추론 (인수의 타입을 통해 추론)
        Integer result4 = GenericMethod.numberMethod(1);
        Double result5 = GenericMethod.numberMethod(1.0);
        Long result6 = GenericMethod.numberMethod(1L);

    }
}
