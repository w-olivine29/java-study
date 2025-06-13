package ch27collection.section10utils.step2immutable;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {
    public static void main(String[] args) {

        //편리한 불변 컬렉션 생성
        List<Integer> list = List.of(1, 2, 3);

        // 값 추가, 삭제, 변경 모두 불가
        //Immutable object is modified  [UnsupportedOperationException]
        //list.add(1);
        //list.set(0, 3);

        Set<Integer> set = Set.of(1, 4, 56, 6, 3);
        Map<Integer, String> map = Map.of(1, "일", 2, "이", 3, "삼");

        System.out.println("class of list: " + list.getClass()); // ImmutableCollections$ListN
        System.out.println("class of set: " + set.getClass()); // ImmutableCollections$SetN
        System.out.println("class of map: " + map.getClass()); // ImmutableCollections$MapN
    }
}
