package ch02io.sub2application.impl.step2filestream;

import ch02io.sub2application.Member;
import ch02io.sub2application.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

// 회원 데이터를 파일에 영구 저장
public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "io-network-reflection/temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {

        // append -> true 실행될때마다 리셋이 아닌, 계속 데이터를 추가할 것임
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, UTF_8, true))) {
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, UTF_8))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] memberData = line.split(DELIMITER); //id, name, age
                members.add(new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2])));
            }
            return members;

        }catch (FileNotFoundException e){
            return List.of();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
/*
개선점)
    - 데이터의 타입을 무시하고 모든 데이터를 문자로 변경해서 저장하는 부분
    - 다시 받아올 때도, 본래 타입으로 변경하는 코드도 작성해야하는 상황
    - 저장, 조회 시에 구분자를 사용해서 각 필드를 구분해야하는 점
*/