package ch21lang.section6math;

public class MathMain {
    public static void main(String[] args) {
        //기본 연산
        System.out.println("최댓값) max(10, 20) -> " + Math.max(10, 20)); //20
        System.out.println("최솟값) min(10, 20) -> " + Math.min(10, 20)); //10
        System.out.println("절댓값) abs(-30) -> " + Math.abs(-30)); //30
        System.out.println("절댓값) abs(30) -> " + Math.abs(30)); //30

        //반올림 & 정밀도
        System.out.println("올림) ceil(4.1): " + Math.ceil(4.1));  //5.0
        System.out.println("반올림) round(4.2): " + Math.round(4.2)); //4
        System.out.println("내림) floor(4.9): " + Math.floor(4.9)); //4.0

        // 기타 (이 외에도 많은 메서드가 있으니 필요할때 찾아보기)
        System.out.println("sqrt(): " + Math.sqrt(77)); // 제곱근 (square root)
        System.out.println("random(): " + Math.random()); // 0.0 ~ 1.0 사이의 double 값

        // BigDecimal: 아주 정밀한 숫자와 반올림 계산 필요시 사용 (돈 정산이나, 정밀한 좌표계산)

    }
}
