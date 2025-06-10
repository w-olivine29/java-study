package ch27collection.section4hash.sub1start;

public class MyHashSetV0Main {
    public static void main(String[] args) {
        MyHashSetV0 set = new MyHashSetV0();

        //O(n) - 추가 시에 중복데이터가 있는지 확인
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println("setV0 = " + set);

        System.out.println("[중복 데이터 저장 결과] set.add(1) =>" + set.add(1));
        System.out.println("set = " + set);

        System.out.println("set.contains(5) => " + set.contains(5)); //O(n)
        System.out.println("set.contains(10) => " + set.contains(10)); //O(n)


        /*
            현재 구현한 Set은 데이터추가, 검색 모두 O(n)
          
         next step)
            해시알고리즘
        */
    }
}
