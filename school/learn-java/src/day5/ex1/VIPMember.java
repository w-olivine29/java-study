package day5.ex1;

/* VIP 회원
- 할인 추가
- 전문 상담원 추가
*/
public class VIPMember extends Member {
    private double saleRatio;
    private String counselor;

    public VIPMember(String name, String id, String counselor) {
        super(name, id);
        saleRatio = 0.10;
        this.counselor = counselor;
    }


    // VIP 회원 포인트 적립 (구매금액의 5%)
    @Override
    public int calculatePoints(int price) {
        return  (int) (price * 0.05);
    }

    @Override
    public void showMemberInfo() {
        super.showMemberInfo();
        System.out.printf("회원등급: VIP, 할인율: %d%%, 전문상담원:%s\n", (int)(saleRatio * 100), counselor);
    }
}
