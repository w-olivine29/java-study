package ch04applylambda.sub2map.step1;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1_Before {
    public static void main(String[] args) {
        List<String> list = List.of("1", "10", "100", "1000", "10000");

        // 문자열 -> 숫자 변환
        List<Integer> numbers = mapStringToInteger(list);
        System.out.println("numbers = " + numbers);

        // 문자열 -> 문자열길이 변환
        List<Integer> lengths = mapStringToLength(list);
        System.out.println("lengths = " + lengths);
    }

    private static List<Integer> mapStringToInteger(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String str : list) {
            result.add(Integer.valueOf(str));
        }
        return result;
    }

    private static List<Integer> mapStringToLength(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String str : list) {
            result.add(str.length());
        }
        return result;
    }
}
