package ch27collection.section5hashset.myhashset.step4generic;


// 직접 만든 객체로 실습
public class MyHashSetV3Main {
    public static void main(String[] args) {

        MyHashSetV3 memberSet = new MyHashSetV3(10);

        Member member1_1 = new Member("ID-001");
        Member member1_2 = new Member("ID-001");

        Member member2 = new Member("ID-002");
        Member member3 = new Member("ID-003");

        System.out.println("member1_1.hashCode() = " + member1_1.hashCode()); // -2140851585
        System.out.println("member1_2.hashCode() = " + member1_2.hashCode()); // -2140851585

        System.out.println("member2.hashCode() = " + member2.hashCode()); //-2140851584
        System.out.println("member3.hashCode() = " + member3.hashCode()); //-2140851583

        memberSet.add(member1_1);
        memberSet.add(member1_2);
        memberSet.add(member2);
        memberSet.add(member3);

        System.out.println("memberSet = " + memberSet);

        //검색
        System.out.println("memberSet.contains(new Member(\"ID-002\")) = "
                + memberSet.contains(new Member("ID-002"))); // true

    }
}
