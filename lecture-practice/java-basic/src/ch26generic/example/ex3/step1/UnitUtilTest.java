package ch26generic.example.ex3.step1;

import ch26generic.example.ex3.ClassUnit;
import ch26generic.example.ex3.Sorcerer;
import ch26generic.example.ex3.Warrior;


/*
- 두 유닛을 입력 받고 체력이 높은 유닛 반환 (같은 경우 둘 중 아무나 반환)
- 제네릭 메서드 사용
- 입력하는 유닛의 타입과 반환하는 유닛의 타입이 동일해야함
 */
public class UnitUtilTest {
    public static void main(String[] args) {

        Warrior warrior1 = new Warrior("닭가슴갑옷",200, 50, 100);
        Warrior warrior2 = new Warrior("단백질폭격기", 250, 50, 120);

        Sorcerer sorcerer1 = new Sorcerer("파이어볼만씀", 50, 200, 60);
        Sorcerer sorcerer2 = new Sorcerer("MP없음", 45, 700, 80);


        ClassUnit maxHpResult1 = UnitUtil.maxHp(warrior1, warrior2);
        System.out.println("warrior1 VS warrior2 maxHp: " + maxHpResult1.toString());

        ClassUnit maxHpResult2 = UnitUtil.maxHp(sorcerer1, sorcerer2);
        System.out.println("sorcerer1 VS sorcerer2 maxHp: " + maxHpResult2.toString());
    }
}
