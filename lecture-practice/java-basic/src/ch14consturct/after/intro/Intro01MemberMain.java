package ch14consturct.after.intro;

/**
 * 객체를 메모리에 할당한 뒤 바로 해당 생성자를 호출
 * new 를 사용해서 객체 생성 시 괄호를 포함해야하는 이유: 객체를 생성하면서 동시에 생성자를 호출한다는 의미
 *
 * 직접 정의한 생성자가 있다면 직접 정의한 생성자를 반드시 호출해야하는 제약이 생긴다.
 * -> 필수값 입력 보장
 */
public class Intro01MemberMain {
    public static void main(String[] args) {

        Member member1 = new Member("회원1", 40, 90);
        Member member2 = new Member("회원2", 30, 50);


        Member[] members = {member1, member2};
        for (Member member : members) {
            System.out.printf("이름: %s, 나이: %d, 점수: %d \n",
                    member.name, member.age, member.grade);
        }
    }

}
