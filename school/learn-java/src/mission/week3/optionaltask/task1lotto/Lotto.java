package mission.week3.optionaltask.task1lotto;

import java.util.Arrays;
import java.util.HashSet;

//41기 유도경
public class Lotto {

    private int[] selectNumbers;
    private int matchCount;

    public Lotto(int[] selectNumbers) {
        this.selectNumbers = selectNumbers;
    }

    public int[] getSelectNumbers() {
        return Arrays.copyOf(selectNumbers, selectNumbers.length); // 원본 데이터를 변경하지 못하도록 복사한 배열로 반환
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(HashSet<Integer> winningNumberSet) {
        int count = 0;
        for (int selectNumber : selectNumbers) {
            if (winningNumberSet.contains(selectNumber)) {
                count++;
            }
        }
        matchCount = count;
    }
}
