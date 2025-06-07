package ch26generic.example.ex3.step1;

import ch26generic.example.ex3.ClassUnit;

public class UnitUtil {

    //두 체력이 같은 경우 둘 중 아무나 반환 -> 첫번째로 고정했음
    public static <T extends ClassUnit> T maxHp(T t1, T t2) {
        return (t1.getHp() >= t2.getHp()) ? t1 : t2;
    }
}
