package mission.week3.optionaltask.task1lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

//41기 유도경
public class LottoGenerator {

    private static final Random random = new Random();


    public static int[] generate() {

        TreeSet<Integer> result = new TreeSet<>(); // 한번에 중복검사 & 정렬하기위함
        for (int i = 0; i < 6; ) {
            int num = random.nextInt(1, 45 + 1);

            if (result.contains(num)) {
                continue;
            }

            result.add(num);
            i++;
        }

        return result.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static List<Lotto> generate(int purchaseCount) {
        List<Lotto> result = new ArrayList<>(purchaseCount);
        for (int i = 0; i < purchaseCount; i++) {
            result.add(new Lotto(generate()));
        }
        return result;
    }
}
