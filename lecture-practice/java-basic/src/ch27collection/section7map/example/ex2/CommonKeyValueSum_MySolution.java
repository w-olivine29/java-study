package ch27collection.section7map.example.ex2;

import java.util.*;

/* 공통의 합
map1 과 map2의 공통 키를 찾고, 그 값의 합 구하기
*/
public class CommonKeyValueSum_MySolution {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("C", 67);
        map1.put("I", 73);
        map1.put("T", 84);
        map1.put("R", 82);
        map1.put("i", 105);
        map1.put("c", 99);

        map2.put("A", 65);
        map2.put("C", 44);
        map2.put("I", 72);
        map2.put("D", 68);


        Set<String> commonKeySet = commonKeySet(map1, map2);
        System.out.println("commonKeySet = " + commonKeySet); //[C, I]

        int resultOfMap1 = sumOfValues(map1, commonKeySet);
        System.out.println("resultOfMap1 = " + resultOfMap1); // 67 + 73 = 140

        int resultOfMap2 = sumOfValues(map2, commonKeySet);
        System.out.println("resultOfMap2 = " + resultOfMap2); // 44 = 72 = 116

    }

    private static <K, V> Set<K> commonKeySet(
            Map<K, V> map1, Map<K, V> map2) {

        Set<K> keySet = map1.keySet();
        keySet.retainAll(map2.keySet());

        return keySet;
    }


    private static <K> int sumOfValues(Map<K, Integer> map, Set<K> keySet) {
        int sum = 0;

        for (K key : keySet) {
            sum += map.get(key) != null ? map.get(key) : 0;
        }
        return sum;
    }
}
