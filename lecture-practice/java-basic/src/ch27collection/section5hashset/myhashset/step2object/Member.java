package ch27collection.section5hashset.myhashset.step2object;


import java.util.Objects;


public class Member {

    private String id;

    public Member(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    
    // id 값이 같으면 동일한 Member로 간주
    // 해시 자료구조에 해당 데이터를 저장할 경우 반드시 hashCode() 재정의 필요
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    // id 값이 같으면 동일한 해시코드 반환
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                '}';
    }
}
