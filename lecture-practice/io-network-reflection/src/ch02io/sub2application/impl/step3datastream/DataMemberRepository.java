package ch02io.sub2application.impl.step3datastream;

import ch02io.sub2application.Member;
import ch02io.sub2application.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "io-network-reflection/temp/members-data.dat";

    @Override
    public void add(Member member) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            while (dis.available() > 0) {
                members.add(new Member(dis.readUTF(), dis.readUTF(), dis.readInt()));
            }
            return members;

        } catch (FileNotFoundException e) {
            return List.of();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/* DataStream 원리

 자바의 다른 타입들은 byte 크기가 정해져있지만, 문자열은 가변 길이 일텐데,
 readUTF() 로 문자를 읽어올 때, 본래의 글자를 어떻게 읽어올 수 있는가?

  예를 들어,
    writeUTF("apple사과");
    writeUTF("바나나banana");
    이런식으로 저장했다면, 
  
    readUTF() -> "apple사과바나나banana" 이 될 것 같은데??
    readUTF() -> "apple사과" 로 정확하게 구분해서 가져오게 됨

    -> writeUTF() 는 UTF-8 형식으로 문자를 저장하면서, 2byte를 추가로 사용하여, 맨 앞에 텍스트의 총 바이트 길이를 같이 저장해놓음
    -> readUTF() 호출 시 먼저 앞의 2Byte인 텍스트의 바이트 길이 확인 후,
       해당 길이 만큼 정확히 글자를 읽어온 뒤 문자열로 변환

    writeUTF("apple사과"); -> 2byte(11) + 11byte (실제 문자 데이터)
    writeUTF("바나나banana"); -> 2byte(15) + 15byte (실제 문자 데이터)

    해당 관련 내용은 옵시디언에 올려놓은 것 참고
*/

/*
모든 데이터를 문자로 저장할 때보다 저장 용량을 더 최적화할 수 있게됨
ex) 1,000,000,000(10억) 문자 저장시 -> 총 10byte 사용
    숫자 하나하나를 각각 문자로 저장해야하기때문에, 각각 1byte 사용
    그러나 자바의 int 타입이면 4byte 사용 
    
    저장 용량을 최적화할 수는 있으나
    이렇게 byte를 직접 저장 시 문서 파일을 열어서 확인, 수정하는게 어려운 단점도 존재 (텍스트가 아닌 부분 디코딩이 안돼서)
*/

/* 
 회원의 필드를 조회해서 각 타입에 맞도록 저장할 수 있게되었으나, 
 회원 객체 자체를 저장한다는 느낌보단, 회원 데이터를 하나하나 분류해서 따로 저장한 상태이다.

 자바 컬럭션에 회원 객체를 저장, 조회했을 때는, 필드를 하나하나 따로 꺼내서 작업하지 않았다.

 next step) List 에 (메모리에 저장돼있는) 있는 객체를 읽어서 파일에 직접 저장할 수는 없을까?
    -> ObjectStream
*/