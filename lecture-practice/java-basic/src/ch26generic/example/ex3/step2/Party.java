package ch26generic.example.ex3.step2;

import ch26generic.example.ex3.ClassUnit;

import java.util.ArrayList;

public class Party<T extends ClassUnit> { // 제네릭 타입을 ClassUnit를 상한으로 두었다

    private int maxNum;
    private ArrayList<T> members; //배열로 선언 시 초기화할때, 제네릭 사용 불가  -> new T[] (제네릭은 new 사용불가)

    public Party(int maxNum) {
        members = new ArrayList<T>(maxNum);
        this.maxNum = maxNum;
    }

    public void addMember(T member) {

        if (members.size() >= maxNum) {
            System.out.println("파티원 추가 불가 - [정원초과]");
            return;
        }

        members.add(member);
    }

    public void showInfo() {
        for (ClassUnit member : members) {
            System.out.println(member);
        }
    }

    public int getMaxCount() {
        return maxNum;
    }

    public T getMember(int order) {
        if (order < 0 || order >= members.size()) {
            System.out.println("잘못된 요청");
            return null;
        }
        return members.get(order);
    }
}
