package mission.week2.challenge.set;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

//41기 유도경
public class MemberManager {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();
        memberManager.execute();
    }

    private final Scanner scanner;
    private final Set<Member> memberSet;


    public MemberManager() {
        this.scanner = new Scanner(System.in);
        this.memberSet = new HashSet<>();
    }

    public void execute() {
        String input;
        try (scanner) {
            while (true) {
                System.out.println("\n회원 관리 시스템 (add, remove, list, check, exit)");
                System.out.print("명령 입력: ");
                input = scanner.nextLine();

                switch (input) {
                    case "add" -> addProcess();
                    case "remove" -> removeProcess();
                    case "list" -> printListProcess();
                    case "check" -> checkProcess();

                    case "exit" -> {
                        System.out.println("프로그램 종료");
                        return;
                    }

                    default -> System.out.println("명령어를 다시 입력해주세요.");
                }
            }
        }
    }

    private long getInputId() {
        long input;
        while (true) {
            try {
                input = scanner.nextLong(); // 숫자만 가져감 (공백문자는 남아있게됨)
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID를 다시 입력해주세요. (숫자만 입력해주세요.)");
            } finally {
                // catch문 - 잘못 입력했던 문자 비우기용 (해당 코드 없으면 무한루프)
                // 정상로직 - 남아있는 공백문자 비우기 (한 프로세스 마친 후의 공백문자로 명령어 입력 방지)
                scanner.nextLine();
            }
        }
        return input;
    }

    private void addProcess() {
        System.out.print("추가할 회원 ID: ");
        if (memberSet.add(new Member(getInputId()))) {
            System.out.println("회원이 추가되었습니다.");
        } else {
            System.out.println("회원이 존재합니다.");
        }

    }

    private void removeProcess() {
        System.out.print("삭제할 회원 ID: ");
        if (memberSet.remove(new Member(getInputId()))) {
            System.out.println("회원이 삭제되었습니다.");
        } else {
            System.out.println("존재하지 않는 회원 ID 입니다.");
        }
    }

    private void printListProcess() {
        System.out.println("현재 회원 목록: ");
        memberSet.forEach(member ->
                System.out.printf("ID: %d, name: %s\n", member.getId(), member.getName()));
    }

    private void checkProcess() {

        System.out.print("검색할 회원 ID: ");
        if (memberSet.contains(new Member(getInputId()))) {
            System.out.println("회원이 존재합니다.");
        } else {
            System.out.println("회원이 존재하지 않습니다.");
        }

    }
}
