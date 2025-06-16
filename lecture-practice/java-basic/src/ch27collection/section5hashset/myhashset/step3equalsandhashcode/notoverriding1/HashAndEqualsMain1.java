package ch27collection.section5hashset.myhashset.step3equalsandhashcode.notoverriding1;

import ch27collection.section5hashset.myhashset.step2object.MyHashSetV2;

public class HashAndEqualsMain1 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberNoHashNoEq member1 = new MemberNoHashNoEq("a");
        MemberNoHashNoEq member2 = new MemberNoHashNoEq("a");

        System.out.println("member1.hashCode() = " + member1.hashCode()); //1922154895 -> 5번 인덱스에 저장
        System.out.println("member2.hashCode() = " + member2.hashCode()); //960604060 -> 0번 인덱스에 저장
        System.out.println("member1.equals(member2) = " + member1.equals(member2)); //false

        set.add(member1);
        set.add(member2);
        System.out.println("set = " + set);


        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("a"); // id가 동일한 객체
        boolean searchResult = set.contains(searchValue);
        
        System.out.println("set.contains(new MemberNoHashNoEq(\"a\") = " + searchResult); // false
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); //1996181658 -> 8번 인덱스에서 찾는다


    }
}
