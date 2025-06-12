package ch27collection.section7map.example.ex1;

import java.util.*;

/* 배열 -> 맵 전환

- 2차원배열의 데이터 -> Map으로 변경
- Map 출력
*/
public class ArrayToMap_MySolution {
    public static void main(String[] args) {
        String[][] menuArray = {
                {"Truffle Oil French Fries", "8000"},
                {"Green Salad", "6000"},
                {"Gorgonzola Pizza", "13000"},
                {"House Wine", "6000"},
                {"Ricotta Cheese Salad", "10000"}
        };

        // array -> map 변환
        Map<String, String> menuMap = toMap(menuArray);

        // map 모든요소 출력
        printMap(menuMap);

    }

    static <E> Map<E, E> toMap(E[][] arr) {
        Map<E, E> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i][0], arr[i][1]);
        }
        return map;
    }

    static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "원");
        }
    }
}
