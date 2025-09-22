package mission.week2;

import java.util.Scanner;

// 41기 유도경
public class JavaTask2_2 {
    public static void main(String[] args) {

        int studentNumber;
        Student[] students;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("학생 수 입력 : ");
                    studentNumber = Integer.parseInt(scanner.nextLine());
                    students = new Student[studentNumber];
                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println("학생 수를 다시 입력해주세요.");
                }
            }


            for (int i = 0; i < studentNumber; i++) {
                String name;
                int grade;
                String classGroup;

                try {
                    System.out.println("학생 정보를 입력하세요.");
                    System.out.print("이름: ");
                    name = scanner.nextLine();

                    System.out.print("학년: ");
                    grade = Integer.parseInt(scanner.nextLine());

                    System.out.print("반: ");
                    classGroup = scanner.nextLine();
                    students[i] = new Student(name, grade, classGroup);

                } catch (IllegalArgumentException e) {
                    System.out.println("다시 입력해주세요.");
                    i--;
                }

            }

            printStudentsInfo(students);
        }

    }


    private static void printStudentsInfo(Student[] students) {
        System.out.println("===== 학생 정보 =====");
        for (Student student : students) {
            System.out.printf("이름: %s\n", student.getName());
            System.out.printf("학년: %d\n", student.getGrade());
            System.out.printf("반: %s\n", student.getClassGroup());
            System.out.println();
        }
    }
}

class Student {

    private String name;
    private int grade;
    private String classGroup;

    public Student(String name, int grade, String classGroup) {
        this.name = name;
        this.grade = grade;
        this.classGroup = classGroup;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getClassGroup() {
        return classGroup;
    }
}
