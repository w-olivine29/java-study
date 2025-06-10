package ch27collection.section5hashset.myhashset.step1integer;

public class MyHashSetV1Main {
    public static void main(String[] args) {
        MyHashSetV1 hashSet = new MyHashSetV1(10);

        //O(n) - 추가 시에 중복데이터가 있는지 확인 (보통 O(1) 성능)
        hashSet.add(1);
        hashSet.add(20);
        hashSet.add(3);
        hashSet.add(40); //20과 해시인덱스 중복
        hashSet.add(9);
        System.out.println("hashSet = " + hashSet);

        System.out.println("[중복 데이터 저장 결과] hashSet.add(1) =>" + hashSet.add(1));
        System.out.println("hashSet = " + hashSet);

        System.out.println("hashSet.contains(5) => " + hashSet.contains(5));
        System.out.println("hashSet.contains(10) => " + hashSet.contains(40));


        boolean removeResult = hashSet.remove(20);
        System.out.println("hashSet.remove(20) => " + removeResult);
        System.out.println("hashSet = " + hashSet);

        /*
           해시 알고리즘 적용
           -> 등록, 검색, 삭제 모두 평균 O(1)으로 개선
               이론상 O(n)이지만 사실상 O(1)에 가까움
        */
    }
}
