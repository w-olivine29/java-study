package ch26generic.example.ex3.step2;

import ch26generic.example.ex3.*;

/*
- 다음 코드와 실행결과 참고하여 Party 클래스 만들기
- Party 클래스 조건
    - 제네릭 타입 사용
    - showInfo() 를 통해 참여한 파티원의 정보 출력
*/
public class PartyTest {
    public static void main(String[] args) {

        // 모든 클래스 모집 파티
        Party<ClassUnit> party = new Party<>(4);
        party.addMember(new Warrior("지방전사", 100, 30, 30));
        party.addMember(new Sorcerer("파이어볼만씀", 70, 150, 30));
        party.addMember(new Hunter("칼쓰는궁수", 150, 100, 50));
        party.addMember(new Assassin("흐콰한다", 100, 70, 40));

        party.addMember(new Hunter("에임은 무의식", 120, 70, 40));

        System.out.println("==== party 정보 출력 ====");
        party.showInfo();

        
        // Sorcerer 모집 파티
        Party<Sorcerer> sorcererParty = new Party<>(3);
        sorcererParty.addMember(new Sorcerer("모솔법사", 100, 120, 50));
        sorcererParty.addMember(new Sorcerer("파이어볼만씀", 70, 150, 30));
        sorcererParty.addMember(new Sorcerer("MP없음", 100, 300, 40));

        System.out.println("\n==== sorcererParty 정보 출력 ====");
        sorcererParty.showInfo();


    }
}
