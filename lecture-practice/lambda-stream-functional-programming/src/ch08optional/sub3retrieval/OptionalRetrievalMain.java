package ch08optional.sub3retrieval;

import java.util.Optional;

public class OptionalRetrievalMain {
    public static void main(String[] args) {
        
        // 예제) 문자열 "olive" 가 있는 Optional과 비어있는 Optional 준비
        Optional<String> optValue = Optional.of("olive");
        Optional<String> empty = Optional.empty();


        System.out.println("\n== 1. isPresent() / isEmpty() ===========================================");
        // isPresent() - 값이 있으면 true
        System.out.println("optValue.isPresent() = " + optValue.isPresent()); //true
        System.out.println("empty.isPresent() = " + empty.isPresent()); //false

        System.out.println("optValue.isEmpty() = " + optValue.isEmpty()); //false
        System.out.println("empty.isEmpty() = " + empty.isEmpty()); //true


        System.out.println("\n== 2. get() ===========================================");
        // get() - 직접 내부 값을 꺼냄 (없으면 NoSuchElementException 발생)
        String getValue = optValue.get();
        System.out.println("getValue = " + getValue);

        //String emptyValue = empty.get(); //NoSuchElementException - No value present


        // orElse() vs orElseGet() -> ch08optional/sub4lazyevaluation/step3optional 참고
        System.out.println("\n== 3. orElse() ===========================================");
        // 값이 있으면 그 값, 없으면 지정된 기본값 사용

        String orElseValue1 = optValue.orElse("defaultValue");
        String orElseValue2 = empty.orElse("defaultValue");

        System.out.println("orElseValue1 = " + orElseValue1); //olive
        System.out.println("orElseValue2 = " + orElseValue2); //defaultValue

        System.out.println("\n== 4. orElseGet() ===========================================");
        // 값이 없을 때만 람다(Supplier) 이 실행되어 기본값 생성

        String orElseGet1 = optValue.orElseGet(() -> {
            System.out.println("람다 호출 - optValue");
            return "defaultValue";
        });
        String orElseGet2 = empty.orElseGet(() -> {
            System.out.println("람다 호출 - empty");
            return "defaultValue";
        });

        System.out.println("orElseGet1 = " + orElseGet1);
        System.out.println("orElseGet2 = " + orElseGet2);

        System.out.println("\n== 5. orElseThrow() ===========================================");
        // 값이 있으면 반환, 없으면 예외 발생 (따로 지정하지 않으면 NoSuchElementException 발생)
        String  orElseThrowValue1 = optValue.orElseThrow(() -> new RuntimeException("값이 없습니다."));
        System.out.println("orElseThrowValue1 = " + orElseThrowValue1);

        try{
            empty.orElseThrow(() -> new RuntimeException("값이 없습니다."));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        System.out.println("\n== 6. or() ===========================================");
        // Optional을 반환 (값이 있으면 있는 그대로 옵셔널 반환, 없으면 람다(Supplier)를 실행하여 옵셔널 반환
        Optional<String> orValue1 = optValue.or(() -> Optional.of("Fallback"));
        System.out.println("orValue1 = " + orValue1); //Optional[olive]

        Optional<String> orValue2 = empty.or(() -> Optional.of("Fallback"));
        System.out.println("orValue2 = " + orValue2); //Optional[Fallback]
    }
}
