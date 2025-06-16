package ch14consturct.before;

// 생성자가 도입 전 1
public class MemberInitMain1 {
    public static void main(String[] args) {

        Member member1 = new Member();
        member1.name = "회원1";
        member1.age = 40;
        member1.grade = 90;

        Member member2 = new Member();
        member2.name = "회원2";
        member2.age = 30;
        member2.grade = 50;

        Member[] members = {member1, member2};
        for (Member member : members) {
            System.out.printf("이름: %s, 나이: %d, 점수: %d \n",
                    member.name, member.age, member.grade);
        }
    }

}
