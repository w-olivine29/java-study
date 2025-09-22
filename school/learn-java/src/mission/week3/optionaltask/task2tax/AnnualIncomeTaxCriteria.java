package mission.week3.optionaltask.task2tax;

import java.util.List;

//41기 유도경
public class AnnualIncomeTaxCriteria {

    // 내부 요소 변경 방지를 위해 모든 요소들을 불변 리스트로 구성
    public static final List<List<Long>> TAXATION = List.of(
            List.of(0L, 12_000_000L),
            List.of(12_000_000L, 46_000_000L),
            List.of(46_000_000L, 88_000_000L),
            List.of(88_000_000L, 150_000_000L),
            List.of(150_000_000L, 300_000_000L),
            List.of(300_000_000L, 500_000_000L),
            List.of(500_000_000L, 1_000_000_000L),
            List.of(1_000_000_000L, 0L));

    public static final List<Integer> TAX_RATE = List.of(6, 15, 24, 35, 38, 40, 42, 45);
    public static final List<Integer> DEDUCTION = List.of(0, 1_080_000, 5_220_000, 14_900_000, 19_400_000, 25_400_000, 35_400_000, 65_400_000);
}
