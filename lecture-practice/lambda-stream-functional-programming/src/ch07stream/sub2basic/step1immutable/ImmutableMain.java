package ch07stream.sub2basic.step1immutable;

import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {
        List<Integer> originList = List.of(1,2,3,4);
        System.out.println("originList = " + originList); //[1, 2, 3, 4]

        // 데이터 소스 변경 x (스트림에서 제공하는 연산들은 원본 컬렉션을 변경하지 않고 결과만 새로 생성)
        List<Integer> filteredList = originList.stream()
                .filter(num -> num % 2 == 0)
                .toList();

        System.out.println("filteredList = " + filteredList); //[2, 4]
        System.out.println("originList = " + originList); //[1, 2, 3, 4]

    }
}
