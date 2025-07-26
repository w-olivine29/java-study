package webservice;

import java.util.List;

// 회원 관리 저장소
public interface MemberRepository {

    void add(Member member); // 회원추가
    List<Member> findAll(); // 회원조회
}
