package mission.week2.challenge.map;

import java.util.*;

// 41기 유도경
public class StudentGradeManager {

    public static void main(String[] args) {
        StudentGradeManager studentGradeManager = new StudentGradeManager();
        studentGradeManager.execute();
    }

    private Map<String, Map<SubjectType, Integer>> studentGradeMap;
    private final Scanner scanner;

    // 처음 시작한다는 가정
    public StudentGradeManager() {
        scanner = new Scanner(System.in);
        studentGradeMap = new HashMap<>();
    }

    // 기존의 학생성적목록으로 시작한다는 가정
    public StudentGradeManager(Map<String, Map<SubjectType, Integer>> existingGradeMap) {
        scanner = new Scanner(System.in);
        this.studentGradeMap = existingGradeMap;
    }


    public void execute() {
        String input;
        try (scanner) {
            while (true) {
                System.out.println("성적 관리 시스템 (add, remove, grade, average, list, exit)");
                System.out.print("명령 입력: ");
                input = scanner.nextLine().toLowerCase();

                System.out.println();
                switch (input) {
                    case "add" -> addProcess();

                    case "remove" -> removeProcess();

                    case "grade" -> gradeProcess();

                    case "average" -> averageProcess();

                    case "list" -> gradeListProcess();

                    case "exit" -> {
                        System.out.println("종료합니다.");
                        return;
                    }
                    default -> System.out.println("명령어를 다시 입력해주세요.");
                }
            }
        }
    }

    private void addProcess() {
        System.out.print("학생 입력: ");
        String name = scanner.nextLine();

        if (studentGradeMap.containsKey(name)) {
            System.out.println("이미 추가된 학생입니다.");
            return;
        }

        studentGradeMap.put(name, new HashMap<>());
        System.out.println("학생이 추가되었습니다.");
    }

    private void removeProcess() {
        System.out.print("삭제할 학생 이름: ");
        String name = scanner.nextLine();

        if (!isStudentExists(name)) return;

        studentGradeMap.remove(name);
        System.out.printf("%s 학생 데이터가 삭제되었습니다.\n", name);
    }

    private void gradeProcess() {

        System.out.print("성적 추가할 학생 이름: ");
        String name = scanner.nextLine();

        if (!isStudentExists(name)) return;

        SubjectType subjectType = inputSubjectType();

        if (!confirmOverwriteGrade(name, subjectType)) {
            System.out.println("성적 입력을 취소합니다.");
            return;
        }

        int score = inputScore(subjectType);

        studentGradeMap.get(name).put(subjectType, score);
        System.out.println("성적이 추가되었습니다.");

    }

    private void gradeListProcess() {
        System.out.println("학생 목록: ");

        if (studentGradeMap.isEmpty()) {
            System.out.println("입력된 학생 데이터가 없습니다.");
            return;
        }
        studentGradeMap.forEach(this::printGrades);
    }

    private void averageProcess() {
        System.out.println("평균 조회할 학생 이름: ");
        String name = scanner.nextLine();

        if (!isStudentExists(name)) return;

        double average = studentGradeMap.get(name).values()
                .stream()
                .mapToInt(Integer::intValue) //IntStream
                .average() //OptionalDouble
                .orElse(0.0);

        System.out.printf("%s의 평균 성적: %.2f\n", name, average);
    }

    private boolean isStudentExists(String name) {

        if (!studentGradeMap.containsKey(name)) {
            System.out.println("존재하지 않은 학생입니다.");
            return false;
        }
        return true;
    }

    private boolean confirmOverwriteGrade(String studentName, SubjectType subjectType) {

        boolean result = true;
        if (studentGradeMap.get(studentName).containsKey(subjectType)) {
            System.out.println("이미 입력된 과목입니다.");

            String input = "";
            while (!("y".equals(input) || "n".equals(input))) {
                System.out.println("기존 점수를 수정하시겠습니까? (y: 수정, n: 취소)");
                input = scanner.nextLine().toLowerCase();
            }

            result = input.equals("y");
        }
        return result;
    }

    private SubjectType inputSubjectType() {

        while (true) {
            try {
                System.out.print("과목 입력: ");
                return SubjectType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("올바른 과목명을 입력해주세요.");
            }
        }
    }

    private int inputScore(SubjectType type) {

        while (true) {
            try {
                System.out.printf("[%s] 성적 입력: ", type.subjectName);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("성적을 다시 입력해주세요.");
            } finally {
                scanner.nextLine(); // 버퍼에 남아있는 개행문자 등 비우기
            }
        }
    }

    // 정해진 과목 순서대로 출력
    private void printGrades(String name, Map<SubjectType, Integer> gradeMap) {

        System.out.printf("%s - 성적: [", name);
        Arrays.stream(SubjectType.values())
                .forEach(subjectType ->
                        System.out.printf("%s: %d  ", subjectType.subjectName, gradeMap.get(subjectType)));
        System.out.println("]");
    }
    
}
