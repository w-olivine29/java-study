package day5.ex1;

public class MemberMain {
    public static void main(String[] args) {
        
        // 일반 회원
        Member member1 = new Member("회원1", "user1");
        member1.processPointAccrual(10000);
        member1.showMemberInfo();

        System.out.println("==================================================");
        // VIP 회원
        Member member2 = new VIPMember("회원2", "user2", "상담원1");
        member2.processPointAccrual(10000);
        member2.showMemberInfo();
        System.out.println("==================================================");
        member2.processPointAccrual(5000);
        member2.showMemberInfo();
    }
}
