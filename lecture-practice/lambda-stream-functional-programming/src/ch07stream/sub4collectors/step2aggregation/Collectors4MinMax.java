package ch07stream.sub4collectors.step2aggregation;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {
    public static void main(String[] args) {
        
        // Collectors 의 일부 기능은 스트림에서 직접 제공하는 기능과 중복
        // 이 기능들은 다운 스트림 컬렉터에서 유용하게 사용
        
        // 다운스트림 컬렉터에서 유용하게 사용
        Integer max1 = Stream.of(1, 2, 3)
                .collect(Collectors.maxBy((a, b) -> a.compareTo(b)))
                .get();
        System.out.println("max1 = " + max1); //3


        Integer max2 = Stream.of(1, 2, 3)
                .max(Integer::compareTo) // (a, b) -> a.compareTo(b);
                .get();
        System.out.println("max2 = " + max2);

        // 기본형 특화 스트림
        int max4 = IntStream.of(1, 2, 3)
                .max()
                .getAsInt();
        System.out.println("max4 = " + max4);
    }
}
