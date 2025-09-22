package day5.ex1;

// 상속을 사용해서 일반 회원과 VIP 회원 만들기

// 기본 회원
public class Member {

    private String name;
    private String id;
    private int point;


    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void processPointAccrual(int price) {
        int point = calculatePoints(price);
        System.out.printf("%s님의 포인트 적립액: %d\n", name, point);
        this.point += point;
    }

    public int calculatePoints(int price) {
        return (int) (price * 0.01);
    }

    // 회원 정보 출력
    public void showMemberInfo() {
        System.out.printf("[%s] 이름: %s, 누적 포인트: %d\n", id, name, point);
    }

}
