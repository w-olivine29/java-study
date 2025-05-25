package ch14consturct.before;

// 생성자가 필요한 이유2
public class MemberInitMain3 {
    public static void main(String[] args) {
        Member member1 = new Member();
        member1.initMember("회원1", 40, 90);

        Member member2 = new Member();
        member2.initMember("회원2", 30, 50);

        Member[] members = {member1, member2};
        for (Member member : members) {
            System.out.printf("이름: %s, 나이: %d, 점수: %d \n",
                    member.name, member.age, member.grade);
        }
    }


}
