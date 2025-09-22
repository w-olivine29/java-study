package mission.week3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static mission.week3.task2.AgeException.*;

// 41기 유도경
public class UserRegisterSystem {
    public static void main(String[] args) {
        UserRegisterSystem system = new UserRegisterSystem();
        system.execute();
    }

    private final Scanner scanner;
    private List<User> userList;

    public UserRegisterSystem() {
        this.scanner = new Scanner(System.in);
        userList = new ArrayList<>();
    }

    public void execute() {

        try (scanner) {
            while (true) {
                System.out.println("\n사용자 등록 시스템 (register, list, exit)");
                System.out.print("명령 입력: ");

                switch (scanner.nextLine()) {

                    case "register" -> registerProcess();
                    case "list" -> listProcess();
                    case "exit" -> {
                        return;
                    }
                    default -> System.out.println("명령을 다시 입력해주세요.");
                }
            }
        } catch (Exception e) { // 예상 외 예외 발생
            System.out.println(e.getMessage());
        } finally {
            System.out.println("시스템 종료");
        }
    }

    private void listProcess() {
        System.out.println("등록된 사용자 목록: ");

        if (userList.isEmpty()) {
            System.out.println("등록된 사용자가 없습니다.");
        }

        userList.forEach(user -> System.out.printf("%s (나이: %d)\n",
                user.getName(), user.getAge()));
    }

    private void registerProcess() {
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();
        while (true) {
            try {
                System.out.print("나이 입력: ");
                int age = Integer.parseInt(scanner.nextLine().strip());
                validateAge(age);

                userList.add(new User(name, age));
                System.out.println("사용자 등록 완료!");
                return;

            } catch (NumberFormatException e) { // 다시 입력하게 유도
                System.out.println("숫자로 입력해주세요.");

            } catch (AgeException e) { // 입력 프로세스 중단
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    private static void validateAge(int age) { // 예외 전파
        if (age < 18) {
            throw new UnderAgeException("미성년자는 등록할 수 없습니다.");
        }
        if (age >= 100) {
            throw new OverAgeException("100세 이상은 등록 불가합니다.");
        }
    }
}

