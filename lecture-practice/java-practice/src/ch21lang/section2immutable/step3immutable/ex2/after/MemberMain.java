package ch21lang.section2immutable.step3immutable.ex2.after;

public class MemberMain {
    public static void main(String[] args) {

        ImmutableAddress address = new ImmutableAddress("노원구");

        // 두 회원 모두 주소가 같아서 같은 주소객체를 대입하였음
        Member memberA = new Member("회원A", address);
        Member memberB = new Member("회원B", address);

        // A,B 회원의 주소 모두 노원구
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원B의 주소를 변경 (새로운 주소 객체를 직접 만들어서 대입)
        memberB.changeAddress(new ImmutableAddress("성북구"));
        System.out.println("memberB -> 성북구");
        System.out.println("memberA = " + memberA); //노원구
        System.out.println("memberB = " + memberB); //성북구
    }
}
