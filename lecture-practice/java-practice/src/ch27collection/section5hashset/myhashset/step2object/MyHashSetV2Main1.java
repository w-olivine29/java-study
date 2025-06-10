package ch27collection.section5hashset.myhashset.step2object;

public class MyHashSetV2Main1 {
    public static void main(String[] args) {
        MyHashSetV2 hashSet = new MyHashSetV2(10);

        hashSet.add("1");
        hashSet.add("20");
        hashSet.add("3");
        hashSet.add("40");
        hashSet.add("9");
        System.out.println("hashSet = " + hashSet);


        System.out.println("\"1\".hashCode() = " + "1".hashCode()); //49
        System.out.println("\"20\".hashCode() = " + "20".hashCode()); //1598
        System.out.println("\"3\".hashCode() = " + "3".hashCode()); //51
        System.out.println("\"40\".hashCode() = " + "40".hashCode()); //1660
        System.out.println("\"9\".hashCode() = " + "9".hashCode()); //57


        System.out.println("[중복 데이터 저장 결과] hashSet.add(1) =>" + hashSet.add(new String("1"))); //false  (참조값을 다르게하려고 같은 리터럴이 아닌 new 사용)
        System.out.println("hashSet = " + hashSet);
        //MyHashSetV2 에서 Object로 받아도, String클래스에서 equals() 와 hashCode() 가 재정의 돼있으니 저장 실패


        System.out.println("hashSet.contains(5) => " + hashSet.contains("5"));
        System.out.println("hashSet.contains(10) => " + hashSet.contains("40"));


        boolean removeResult = hashSet.remove(20);
        System.out.println("hashSet.remove(20) => " + removeResult);
        System.out.println("hashSet = " + hashSet);


    }
}
