package optionaltask.task2;

import java.util.List;

public class StatisticsUtils {
    public static Integer sum(List<Integer> values) {
        return values.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static Double average(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static List<Integer> evenNumbers(List<Integer> values) {
        return values.stream()
                .filter(num -> num % 2 == 0)
                .toList();
    }

    public static List<Integer> oddNumbers(List<Integer> values) {
        return values.stream()
                .filter(num -> num % 2 != 0)
                .toList();
    }

    public static int min(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }

    public static int max(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }


    public static List<Integer> distinctSortNumbers(List<Integer> values) {
        return values.stream()
                .distinct()
                .sorted()
                .toList();
    }
}
