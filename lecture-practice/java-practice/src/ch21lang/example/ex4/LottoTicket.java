package ch21lang.example.ex4;

import java.util.Arrays;

public class LottoTicket {

    private final int[] nums;

    public LottoTicket(int[] nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return Arrays.toString(nums);
    }
}
