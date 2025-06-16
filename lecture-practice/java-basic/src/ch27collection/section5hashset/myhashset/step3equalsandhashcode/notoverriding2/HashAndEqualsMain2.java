package ch27collection.section5hashset.myhashset.step3equalsandhashcode.notoverriding2;

import ch27collection.section5hashset.myhashset.step2object.MyHashSetV2;

public class HashAndEqualsMain2 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberNoEq member1 = new MemberNoEq("a");
        MemberNoEq member2 = new MemberNoEq("a");

        System.out.println("member1.hashCode() = " + member1.hashCode()); //128 -> 8번 인덱스에 저장
        System.out.println("member2.hashCode() = " + member2.hashCode()); //128 -> 8번 인덱스에 저장
        System.out.println("member1.equals(member2) = " + member1.equals(member2)); //false

        set.add(member1);
        set.add(member2);
        System.out.println("set = " + set);


        MemberNoEq searchValue = new MemberNoEq("a"); // 동일한 id -> 동일한 해시코드
        boolean searchResult = set.contains(searchValue);

        System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); //128 -> 8번 인덱스에서 찾는다
        System.out.println("set.contains(new MemberNoHashNoEq(\"a\") = " + searchResult); // false

        // 같은 해시인덱스의 위치에 저장되지만, equals() 에서 false 반환

    }
}
