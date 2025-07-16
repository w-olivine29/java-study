package ch02io.sub2application.impl.step1memory;

import ch02io.sub2application.Member;
import ch02io.sub2application.MemberRepository;

import java.util.ArrayList;
import java.util.List;

// 자바 메모리 활용 -> 자바가 종료되면 사라짐
public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void add(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
