package ch27collection.section7map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//Map 구현체
public class MapMain3 {
    public static void main(String[] args) {

        run(new HashMap<>());
        run(new LinkedHashMap<>());
        run(new TreeMap<>());

        run(new Hashtable<>());  // 레거시, 메서드 전체 동기화 (낮은 성능)
        run(Collections.synchronizedMap(new HashMap<>())); // HashMap 동기화 래퍼, 반복 시 별도 동기화 필요
        run(new ConcurrentHashMap<>()); // 고성능 동시성 지원, 부분 락킹 사용
    }

    private static void run(Map<String, Integer> map) {
        System.out.println(map.getClass());
        map.put("h", 104);
        map.put("a", 97);
        map.put("s", 115);
        map.put("8", 56);
        map.put("m", 109);
        map.put("1", 49);
        map.put("p", 112);
        map.put("h", 0); //중복 키 (나중에 put을 해도 기존에 있던것에 덮어씌우는 것이기때문에, 들어간 순서는 h가 1순위)

        for (String key : map.keySet()) {
            System.out.printf("key: %s, value: %d\n", key, map.get(key));
        }
        System.out.println();
    }

}
