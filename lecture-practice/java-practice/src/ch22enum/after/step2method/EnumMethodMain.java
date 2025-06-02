package ch22enum.after.step2method;

import java.util.Arrays;

public class EnumMethodMain {
    public static void main(String[] args) {

        // 모든 Enum 상수 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values)); //values = [BASIC, GOLD, DIAMOND]


        // name(): 상수의 "이름"을 문자열로 반환
        // ordinal(): 상수 선언 순서 반환 (0부터 시작) -> 가급적 사용x
        for (Grade value : values) {
            System.out.printf("name: %s, ordinal: %d\n", value.name(), value.ordinal());
        }


        // String -> Enum 변환 (주어진 이름과 일치해야함)
        Grade GOLD = Grade.valueOf("GOLD");

        Grade gold = Grade.valueOf("gold");
        // IllegalArgumentException 발생 (No enum constant ch22enum.after.step2method.Grade.gold)

        Grade silver = Grade.valueOf("silver");
        // IllegalArgumentException 발생 (No enum constant ch22enum.after.step2method.Grade.silver)

    }
}
