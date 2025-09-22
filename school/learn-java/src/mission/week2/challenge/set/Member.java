package mission.week2.challenge.set;

import java.util.Objects;

//41기 유도경
public class Member {

    private final Long id;
    private String name; //이름 정보는 있을수도 없을수도 있다는 가정

    public Member(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
