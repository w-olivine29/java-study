package ch04applylambda.sub2map.step2util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static ch04applylambda.sub2map.step2util.StringToIntegerMapper.*;

public class MapMainV2 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "10", "100", "1000", "10000");

        // 문자열 -> 숫자 변환
        List<Integer> numbers = map(list, str -> Integer.valueOf(str));
        System.out.println("numbers = " + numbers);

        // 문자열 -> 문자열길이 변환
        List<Integer> lengths =  map(list, str -> str.length());
        System.out.println("lengths = " + lengths);
    }

}
