package ch07stream.sub3operation.step3terminal;

import java.util.Optional;

// 스트림의 최종 연산의 이해에 필요한 정도만 진행 (더 깊은 내용은 Optional 챕터 참고)
public class OptionalSimpleMain {
    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.of(10);
        System.out.println("optional1 = " + optional1);

        if(optional1.isPresent()){ // 값이 있는지 확인할 수 있는 안전한 메서드 제공
            Integer integer = optional1.get();
            System.out.println("integer = " + integer);
        }

// =======================================================================================
        Optional<Integer> optional2 = Optional.ofNullable(null);
        System.out.println("optional2 = " + optional2); //optional2 = Optional.empty

        if(optional2.isPresent()){
            Integer integer = optional2.get();
            System.out.println("integer = " + integer);
        }
        // 값이 없는 Optional 에서 get() 호출 시 NoSuchElementException 발생
        //Integer nullOptional = optional2.get(); //No value present
    }
}
/*
 Optional 은
 null 값으로 인한 오류를 방지 
 코드에서 "값이 없을 수도 있다" 라는 상황을 명시적으로 표현하기 위해 사용

 -> null 을 직접 다루는 대신 Optional 를 사용하면 값의 유무를 안전하게 처리 가능
    코드를 더 명확하고 안정적으로 작성 가능
*/