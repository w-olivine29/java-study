package ch14consturct.before;

// 생성자 도입 전2
public class MemberInitMain2 {
    public static void main(String[] args) {
        Member member1 = new Member();
        initMember(member1, "회원1", 40, 90);

        Member member2 = new Member();
        initMember(member2, "회원2", 30, 50);

        Member[] members = {member1, member2};
        for (Member member : members) {
            System.out.printf("이름: %s, 나이: %d, 점수: %d \n",
                    member.name, member.age, member.grade);
        }
    }

    // Member를 초기화하는 것을 메서드로 만들었지만, 객체지향적이지 못하다. (데이터와 기능이 분리된 상태)
    static void initMember(Member member, String name, int age, int grade) {
        member.name = name;
        member.age = age;
        member.grade = grade;
    }

}
