package ch02io.sub2application.impl.step4objectstream;

import ch02io.sub2application.Member;
import ch02io.sub2application.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "io-network-reflection/temp/members-obj.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll();
        members.add(member);

        // 객체 직렬화를 해주는 스트림
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(members); // 리스트를 통으로 파일에 저장

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object findObject = ois.readObject();
            return (List<Member>) findObject;

        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // 여기서 List.of를 쓰면 반환 리스트를 add()에서 사용 불가 (불변 리스트)

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }
}

/* 
객체 직렬화
   메모리에 있는 객체 인스턴스 -> 바이트 코드 변환 -> 파일에 저장 or 네트워크 전송

객체 역직렬화
    원래 객체로 복원
   
*/

/* 왜 append false로 하고 리스트 전체를 저장하는가?

 // 파일에서 읽을 때 몇 개의 객체가 있는지 알 수 없음
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
        while (true) { // 언제 끝날지 모름
            Member member = (Member) ois.readObject(); // EOFException 발생할 때까지?
        }
    }


리스트가 아닌 개별 객체를 저장하고싶다면?

객체 개수를 먼저 저장
public void add(List<Member> members) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
        oos.writeInt(members.size()); // 먼저 개수 저장
        for (Member member : members) {
            oos.writeObject(member); // 각 객체 저장
        }
    }
}

public List<Member> findAll() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
        int size = ois.readInt(); // 개수 먼저 읽기
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            members.add((Member) ois.readObject()); // 개수만큼 읽기
        }
        return members;
    }
}

*/

/*
현대에는 객체 직렬화를 거의 사용하지 않는다.
사용하면 장애가 날 가능성이 엄청 높다?

1. 보안문제
    악의적인 직렬화된 데이터로  인한 보안 취약점
    역직렬화 과정에서 임의 코드 실행 가능

2. 버전 호환성
    예를 들어 객체에 필드를 새로 추가
    -> 기존에 저장된 코드들을 역직렬화해서 읽어올 때 오류 발생


3. 성능문제
    직렬화, 역직렬화 과정이 느림
    메모리 사용량이 많음
    파일 크기가 큼

4. 플랫폼 종속성
    Java 에서만 읽을 수 있음


대안)
XML, JSON, 데이터베이스 등 사용
자세한 내용은 pdf 참고
*/