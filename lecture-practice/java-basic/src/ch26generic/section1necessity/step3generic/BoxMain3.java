package ch26generic.section1necessity.step3generic;


public class BoxMain3 {
    public static void main(String[] args) {

        // 생성 시점에 <T> 타입 결정
        GenericBox<Integer> integerBox = new GenericBox<Integer>(); //타입 직접 입력
        //integerBox.set("10"); // 잘못된 타입의 인수 전달 시 컴파일 에러

        integerBox.set(10);
        Integer integer = integerBox.get(); // 생성시점에 결정된 타입으로 반환 (다운캐스팅 필요 x)
        System.out.println("integer = " + integer);


        GenericBox<String> stringBox = new GenericBox<>(); //타입 추론 (왼쪽에 있는 선언된 변수를 보고 타입추론 -> 타입정보 생략가능)
        stringBox.set("문자열");
        String string = stringBox.get();
        System.out.println("string = " + string);

        
        //원하는 모든 타입 사용 가능
        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(1.0);

        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);


        /*
          제네릭을 사용하면 객체 생성 시 타입이 결정되므로,
          타입 안정성이 보장되고 잘못된 타입 입력을 컴파일 단계에서 막을 수 있음

          또한, 값을 꺼낼 때 다운캐스팅 없이 바로 사용할 수 있어 안전하고 편리

          다양한 타입에 대해 하나의 클래스를 재사용할 수 있어 코드 재사용성 높음
        */


        /*
        제너릭 명명관례
            E - Element
            K - Key
            N - Number
            T - Type
            V - Value
            S,U,V etc - 2nd, 3rd, 4th types

        한번에 여러 타입 매개변수 선언 가능
         ex) class Data<K,V>{}
        */

    }
}
