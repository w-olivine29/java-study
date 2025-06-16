package ch26generic.example.ex3.step3;

import ch26generic.example.ex3.ClassUnit;
import ch26generic.example.ex3.step2.Party;

public class ClassUnitPrinter {

    //제네릭 메서드
    public static <T extends ClassUnit> void printV1(Party<T> party) {

        for (int i = 0; i < party.getMaxCount(); i++) {
            T member = party.getMember(i);
            System.out.printf("닉네임: %s, hp: %d, mp: %d, stamina: %d\n",
                    member.getName(), member.getHp(), member.getMp(), member.getStamina()
            );
        }
    }

    //와일드카드
    public static void printV2(Party<? extends ClassUnit> party) {

        for (int i = 0; i < party.getMaxCount(); i++) {
            ClassUnit member = party.getMember(i);
            System.out.printf("닉네임: %s, hp: %d, mp: %d, stamina: %d\n",
                    member.getName(), member.getHp(), member.getMp(), member.getStamina()
            );
        }
    }
}
