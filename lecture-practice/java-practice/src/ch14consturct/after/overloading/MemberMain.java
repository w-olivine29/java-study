package ch14consturct.after.overloading;


public class MemberMain {
    public static void main(String[] args) {

        Member member1 = new Member("회원1", 40, 90);
        Member member2 = new Member("회원3", 10);


        Member[] members = {member1, member2};
        for (Member member : members) {
            System.out.printf("이름: %s, 나이: %d, 점수: %d \n",
                    member.name, member.age, member.grade);
        }
    }
}
