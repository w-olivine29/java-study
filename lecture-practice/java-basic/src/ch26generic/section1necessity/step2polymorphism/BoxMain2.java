package ch26generic.section1necessity.step2polymorphism;

public class BoxMain2 {
    public static void main(String[] args) {

        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10); // Integer -> Object 타입으로 저장 (업캐스팅)

        // 다시 꺼낼 땐 object인 상태
        Integer integer = (Integer) integerBox.get(); // Integer로 사용하기 위해 다운캐스팅
        System.out.println("integer = " + integer);


        ObjectBox stringBox = new ObjectBox();
        stringBox.set("문자열"); // String -> Object 타입으로 저장 (업캐스팅)
        String string = (String) stringBox.get(); // String 으로 사용하기 위해 다운캐스팅


        // 잘못된 타입의 인수 전달 시
        integerBox.set("10");
        //Integer integer1 = (Integer) integerBox.get(); // ClassCastException


        /*
        다형성 활용으로 코드 중복제거, 코드 재사용 가능해짐
        그러나 타입 안정성 문제가 크다.
        - set() -> 의도하지 않는 타입도 들어갈 수 있는 문제
        - get() -> 다운캐스팅 필요 (원하는 타입으로 정확하게 받을 수 없음)
            컴파일 단계에서 타입 검증이 불가하기때문에 항상 위험한 다운 캐스팅 시도
        
        <-> step1은 코드중복이 있었으나 타입 안정성은 확보됐던 상태

        next step)
         코드 재사용성과 타입안정성을 모두 잡을 수 없을까?
         -> 제네릭 도입
        */
    }
}
