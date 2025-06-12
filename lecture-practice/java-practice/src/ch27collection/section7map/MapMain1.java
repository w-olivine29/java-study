package ch27collection.section7map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain1 {
    public static void main(String[] args) {
        Map<String, Integer> menuSet = new HashMap<>();

        menuSet.put("newYorkStripSteak", 47900);
        menuSet.put("bbqTomahawkSteak", 24900);
        menuSet.put("truffleMushroomCreamPasta", 8900);
        menuSet.put("vongolePasta", 8900);

        System.out.println("menuSet = " + menuSet);
        // menuSet = {bbqTomahawkSteak=24900, newYorkStripSteak=47900, vongolePasta=8900, truffleMushroomCreamPasta=8900}

        //특정 값 조회 (key 값을 통해 접근 -> 해당 key의 value 반환)
        Integer newYorkStripSteak = menuSet.get("newYorkStripSteak");
        System.out.println("menuSet.get(\"newYorkStripSteak\") = " + newYorkStripSteak);

        //keySet
        Set<String> keySet = menuSet.keySet();
        for (String string : keySet) {
            System.out.println(string + "= " + menuSet.get(string));
        }

        //values
        Collection<Integer> values = menuSet.values(); //class java.util.HashMap$Values
        System.out.println("values = " + values);

        //entrySet
        Set<Map.Entry<String, Integer>> entrySet = menuSet.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
