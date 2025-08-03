package ch04applylambda.sub2map.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV1_After {
    public static void main(String[] args) {
        List<String> list = List.of("1", "10", "100", "1000", "10000");

        // 문자열 -> 숫자 변환
        List<Integer> numbers = map(list, str -> Integer.valueOf(str));
        System.out.println("numbers = " + numbers);

        // 문자열 -> 문자열길이 변환
        List<Integer> lengths = map(list, str -> str.length());
        System.out.println("lengths = " + lengths);
    }

    private static List<Integer> map(List<String> list, Function<String, Integer> mapper) {
        List<Integer> result = new ArrayList<>();
        for (String str : list) {
            result.add(mapper.apply(str));
        }
        return result;
    }
}
