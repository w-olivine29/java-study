package ch27collection.section7map;

import java.util.HashMap;
import java.util.Map;

public class MapMain2 {
    public static void main(String[] args) {
        Map<String, Integer> menuSet = new HashMap<>();

        menuSet.put("newYorkStripSteak", 47900);
        menuSet.put("bbqTomahawkSteak", 24900);


        System.out.println("menuSet = " + menuSet);
        // menuSet = {bbqTomahawkSteak=24900, newYorkStripSteak=47900}

        //특정 값 조회 (key 값을 통해 접근 -> 해당 key의 value 반환)
        Integer newYorkStripSteak = menuSet.get("newYorkStripSteak");
        System.out.println("menuSet.get(\"newYorkStripSteak\") = " + newYorkStripSteak);

        // 중복 키 저장 시 기존 값 교체
        menuSet.put("newYorkStripSteak", 50000);
        System.out.println("menuSet = " + menuSet);
        //menuSet = {bbqTomahawkSteak=24900, newYorkStripSteak=50000}

        // 키 값 존재여부
        boolean containsKey1 = menuSet.containsKey("newYorkStripSteak");
        System.out.println("menuSet.containsKey(\"newYorkStripSteak\") = " + containsKey1); //true

        boolean containsKey2 = menuSet.containsKey("vongolePasta");
        System.out.println("menuSet.containsKey(\"vongolePasta\") = " + containsKey2); //false

        // 특정 값 삭제
        Integer removedKey1 = menuSet.remove("newYorkStripSteak");
        System.out.println("menuSet = " + menuSet); //{bbqTomahawkSteak=24900}

// =========================================================================================

        menuSet = new HashMap<>(Map.of(
                "newYorkStripSteak", 47900,
                //"bbqTomahawkSteak", 24900,
                "truffleMushroomCreamPasta", 8900,
                "vongolePasta", 8900));

        // 값 덮어씌우기 X
        // 특정 값이 없는 경우에만 저장1
        if (!menuSet.containsKey("bbqTomahawkSteak")) {
            menuSet.put("bbqTomahawkSteak", 24900);
        }

        // 특정 값이 없는 경우에만 저장2
        menuSet.putIfAbsent("truffleFries", 7000);

        System.out.println("menuSet = " + menuSet);

    }
}

