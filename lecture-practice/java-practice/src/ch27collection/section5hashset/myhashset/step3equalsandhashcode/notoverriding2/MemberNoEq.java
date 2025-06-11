package ch27collection.section5hashset.myhashset.step3equalsandhashcode.notoverriding2;

import java.util.Objects;

public class MemberNoEq {

    private String id;

    public MemberNoEq(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MemberNoEq{" +
                "id='" + id + '\'' +
                '}';
    }
}
