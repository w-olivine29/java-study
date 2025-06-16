package ch22enum.before.step1;

/* 비즈니스 요구사항
 * 고객은 3등급으로 나누고, 상품 구매 시 등급별로 할인 적용 (할인 시 소수점 이하는 버린다)
 *
 * BASIC -> 10%
 * GOLD -> 20%
 * DIAMOND -> 30%
 * */
public class DiscountService {

    public int discount(String grade, int price) {
        int discountPercent = 0;

        if ("BASIC".equals(grade)) {
            discountPercent = 10;
        } else if ("GOLD".equals(grade)) {
            discountPercent = 20;
        } else if ("DIAMOND".equals(grade)) {
            discountPercent = 30;
        } else {
            System.out.println(grade + ": 할인 X");
        }

        return price * discountPercent / 100;
    }

    /* 문자열로 받을 떄의 문제점
     * - 타입안정성 부족(값 제한 부족)
     *   ex) 오타, 유효하지 않은 값 입력 가능
     *
     * - 컴파일 오류 감지 불가
     *
     * - 데이터 일관성 X
     *    ex) "GOLD", "gold", "Gold"
     * */
}
