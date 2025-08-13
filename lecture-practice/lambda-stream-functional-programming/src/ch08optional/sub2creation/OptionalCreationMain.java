package ch08optional.sub2creation;

import java.util.Optional;

public class OptionalCreationMain {
    public static void main(String[] args) {

        // 1. of() - 값이 null 이 아님이 확실할 때 사용 (null 이면 NullPointerException)
        String nonNulLValue = "Welcome Optional!";
        Optional<String> optional1 = Optional.of(nonNulLValue);
        System.out.println("optional1 = " + optional1); //Optional[Welcome Optional!]
        
        // 2. ofNullable() - 값이 null 일 수도 아닐 수도 있을 때
        Optional<String> optional2_1 = Optional.ofNullable("Welcome!");
        Optional<String> optional2_2 = Optional.ofNullable(null);

        System.out.println("optional2_1 = " + optional2_1); //Optional[Welcome!]
        System.out.println("optional2_2 = " + optional2_2); //Optional.empty

        // 3. empty() - 비어있는 Optional 을 명시적으로 생성
        Optional<Object> empty = Optional.empty();
        System.out.println("empty = " + empty); //Optional.empty
    }
}
