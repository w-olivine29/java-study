package ch26generic.example.ex3.step3;

import ch26generic.example.ex3.Sorcerer;
import ch26generic.example.ex3.step2.Party;

/*
step2 에서 만든 Party를 활용
다음 코드와 실행 결과를 참고하여, ClassUnitPrinter 를 만들기

ClassUnitPrinter.print 구현
Party에 참여 중인 유닛의 정보 출력
    ClassUnitPrinter.printV1() -> 제네릭 메서드로 구현
    ClassUnitPrinter.printV2() -> 와일드카드로 구현
*/
public class ClassUnitPrinterTest {
    public static void main(String[] args) {

        // Sorcerer 모집 파티
        Party<Sorcerer> sorcererParty = new Party<>(3);
        sorcererParty.addMember(new Sorcerer("모솔법사", 100, 120, 50));
        sorcererParty.addMember(new Sorcerer("파이어볼만씀", 70, 150, 30));
        sorcererParty.addMember(new Sorcerer("MP없음", 100, 300, 40));


        System.out.println("ClassUnitPrinter.printV1");
        ClassUnitPrinter.printV1(sorcererParty);

        System.out.println("\nClassUnitPrinter.printV2");
        ClassUnitPrinter.printV2(sorcererParty);

    }
}
