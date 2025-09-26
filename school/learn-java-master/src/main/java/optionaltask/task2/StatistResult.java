package optionaltask.task2;

import java.util.List;

import static optionaltask.task2.StatisticsUtils.*;

public class StatistResult {

    private final List<Integer> values;

    private final int sum;
    private final double average;

    private final int min;
    private final int max;

    private final List<Integer> evenNumbers;
    private final List<Integer> oddNumbers;

    private final List<Integer> distinctSortNumbers;


    public static StatistResult from(List<Integer> values) {
        int sum = sum(values);
        double average = average(values);
        int min = min(values);
        int max = max(values);
        List<Integer> evenNumbers = evenNumbers(values);
        List<Integer> oddNumbers = oddNumbers(values);
        List<Integer> distinctSortNumbers = distinctSortNumbers(values);

        return new StatistResult(values, sum, average, min, max, evenNumbers, oddNumbers, distinctSortNumbers);
    }

    public StatistResult(List<Integer> values, int sum, double average, int min, int max, List<Integer> evenNumbers, List<Integer> oddNumbers, List<Integer> distinctSortNumbers) {
        this.values = values;
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
        this.distinctSortNumbers = distinctSortNumbers;
    }

    public void printTotalResult() {

        System.out.printf("입력된 숫자 개수: %d\n",values.size());
        System.out.printf("입력된 숫자: %s\n",values);
        System.out.printf("합계: %d\n", sum);
        System.out.printf("평균: %.2f\n", average);
        System.out.printf("짝수: %s\n", evenNumbers);
        System.out.printf("홀수: %s\n", oddNumbers);
        System.out.printf("최댓값: %d\n", max);
        System.out.printf("최솟값: %d\n", min);
        System.out.printf("중복 제거 후 정렬된 숫자: %s\n",distinctSortNumbers);
    }
}



