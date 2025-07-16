package ch02io.sub2application;

import ch02io.sub2application.impl.step1memory.MemoryMemberRepository;
import ch02io.sub2application.impl.step2filestream.FileMemberRepository;
import ch02io.sub2application.impl.step3datastream.DataMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {
    //private static final MemberRepository repository = new MemoryMemberRepository();
    //private static final MemberRepository repository = new FileMemberRepository();
    private static final MemberRepository repository = new DataMemberRepository();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.회원 등록 | 2.회원 목록 조회 | 3.종료 ");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 남은 개행문자 소모

            switch (choice){
                case 1:
                    // 회원 등록
                    registerMember(scanner);
                    break;
                case 2:
                    // 회원 목록 조회
                    displayMembers();
                    break;
                case 3:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("ID 입력: ");
        String id = scanner.nextLine();

        System.out.print("Name 입력: ");
        String name = scanner.nextLine();

        System.out.print("Age 입력: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // 남은 개행문자 제거

        Member newMember = new Member(id, name, age);
        repository.add(newMember);
        System.out.println("회원이 성공적으로 등록되었습니다.");
    }

    private static void displayMembers() {
        List<Member> members = repository.findAll();
        System.out.println("회원 목록:");
        for (Member member : members) {
            System.out.printf("[ID: %s, Name: %s, Age: %d]\n", member.getId(), member.getName(), member.getAge());
        }
    }
}
