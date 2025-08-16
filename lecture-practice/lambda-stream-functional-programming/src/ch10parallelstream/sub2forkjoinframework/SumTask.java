package ch10parallelstream.sub2forkjoinframework;

import ch10parallelstream.HeavyJob;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import static ch10parallelstream.util.MyLogger.log;

// 과정 pdf 참고
// 작업 훔치기 알고리즘 pdf 참고
public class SumTask extends RecursiveTask<Integer> {

    // 최적의 임계값: pdf 참고
    private static final int THRESHOLD = 4; // 작업을 더 이상 분할하지 않고 직접 처리할 리스트의 크기 정의 (해당 크기 이하일 떄 직접 계산)

    private final List<Integer> list;

    // 분할 작업할 데이터들을 받아옴
    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {

        // 작업 범위가 작으면 직접 계산 (5~8)
        if (list.size() < THRESHOLD) {

            log("[처리 시작]" + list);

            int sum = list.stream()
                    .mapToInt(HeavyJob::heavyTask)
                    .sum();
            log(String.format("[처리 완료] %s -> sum: %d", list, sum));
            return sum;

        } else { // 작업 범위가 임계값보다 크면 분할 -> 병렬처리
            int mid = list.size() / 2;
            List<Integer> leftList = list.subList(0, mid);
            List<Integer> rightList = list.subList(mid, list.size());
            log(String.format("[분할] %s -> LEFT: %s, RIGHT: %s", list, leftList, rightList));

            // 재귀
            SumTask leftTask = new SumTask(leftList);
            SumTask rightTask = new SumTask(rightList);

            // 왼쪽 작업은 다른 스레드에 위임하여 병렬 처리 [1~4]
            leftTask.fork();// return ForkJoinTask<Integer>

            // 오른쪽 작업은 현재 스레드에서 직접 수행 (재귀호출) [5~8]
            Integer rightResult = rightTask.compute();

            // 왼쪽 작업 결과를 기다리고 결과값 받기
            Integer leftResult = leftTask.join();
            int joinSum = leftResult + rightResult;

            log(String.format("LEFT[%s] RIGHT[%s] -> sum: %d", leftResult, rightResult, joinSum));
            return joinSum;
        }
    }
}
