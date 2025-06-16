package ch27collection.section7map.example.ex6;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository_MySolution {

    private Map<String, Member> members = new HashMap<>();

    public void save(Member member) {
        members.putIfAbsent(member.getId(), member);
    }

    public Member findById(String id) {
        return members.get(id);
    }

    public Member findByName(String name) {
        for (Member member : members.values()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void remove(String id) {
        members.remove(id);
    }

    public void showMembers() {
        for (String key : members.keySet()) {
            System.out.println(members.get(key));
        }
    }
}
