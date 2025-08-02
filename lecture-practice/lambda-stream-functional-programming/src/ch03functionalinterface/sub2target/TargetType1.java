package ch03functionalinterface.sub2target;

public class TargetType1 {
    public static void main(String[] args) {

        // 람다는 그 자체만으로 타입이 정해져있지 않고, 대입되는 함수형 인터페이스(타켓 타입)에 의해 타입이 결정
        FunctionA functionA = i -> "value=" + i;
        FunctionA functionB = i -> "value=" + i;

        // 이미 만들어진 FunctionA 인스턴스를 FunctionB에 대입 
        //FunctionB targetB = functionA; // 컴파일 에러 (자바 타입 시스템상 전혀 다른 인터페이스)
        // 메서드 시그니처가 같음에도 타입이 달라서 호환불가
        // -> 이를 위해 자바가 기본 인터페이스 제공
    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer integer);
    }

    @FunctionalInterface
    interface FunctionB {
        String apply(Integer integer);
    }
}
