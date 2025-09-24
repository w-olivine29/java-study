package ch01jvm.oom.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication2 {

    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        LottoGenerator generator = new LottoGenerator();
        while (true) {
            List<Integer> lottoNumbers = generator.generate();
            System.out.println(lottoNumbers);

            if (lottoHistory.size() > 100) {
                lottoHistory.clear();
            }
            lottoHistory.add(lottoNumbers);
        }
    }
}