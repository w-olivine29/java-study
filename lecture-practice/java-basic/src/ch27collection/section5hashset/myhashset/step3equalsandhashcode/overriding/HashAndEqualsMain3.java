package ch27collection.section5hashset.myhashset.step3equalsandhashcode.overriding;

import ch27collection.section5hashset.myhashset.step2object.MyHashSetV2;

public class HashAndEqualsMain3 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        Member member1 = new Member("a");
        Member member2 = new Member("a");

        System.out.println("member1.hashCode() = " + member1.hashCode()); //128 -> 8번 인덱스에 저장
        System.out.println("member2.hashCode() = " + member2.hashCode()); //128 -> 8번 인덱스에 저장
        System.out.println("member1.equals(member2) = " + member1.equals(member2)); //true

        set.add(member1);
        set.add(member2);
        System.out.println("set = " + set);


        Member searchValue = new Member("a"); // 동일한 id -> 동일한 해시코드
        boolean searchResult = set.contains(searchValue);

        System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); //128 -> 8번 인덱스에서 찾는다
        System.out.println("set.contains(new MemberNoHashNoEq(\"a\") = " + searchResult); // true


    }
}
