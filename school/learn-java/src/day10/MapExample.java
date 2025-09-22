package day10;

import java.util.HashMap;

public class MapExample {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        // 추가
        map.put(1, "일");
        map.put(2, "이");
        map.put(3, "삼");
        System.out.println(map); //{1=일, 2=이, 3=삼}


        map.put(3, "3"); // key가 3인 요소의 값 덮어쓰우기
        
        // 검색
        System.out.println("map.get(1) = " + map.get(1)); //일
        System.out.println("map.get(2) = " + map.get(2)); //이
        System.out.println("map.get(3) = " + map.get(3)); //3
        System.out.println("map.getOrDefault(4, \"기본값\") = " + map.getOrDefault(4, "기본값"));


        // 삭제
        map.remove(3);

        System.out.println("map.get(3) = " + map.get(3)); // null
    }
}
