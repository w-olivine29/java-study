package ch01jvm.oom.lotto;

import java.util.ArrayList;
import java.util.List;

//visualVM 으로 Heap 메모리 상태 모니터링
public class LottoApplication1 {
    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    // OOM 발생 시뮬레이션
    public static void main(String[] args) throws InterruptedException {
        LottoGenerator generator = new LottoGenerator();
        while (true) {
            List<Integer> lottoNumbers = generator.generate();
            System.out.println(lottoNumbers);
            lottoHistory.add(lottoNumbers);

        }
    }
}