package ch12reference;

public class Ref03Method1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        initStudent(student1, 1, "학생1", 80, 20);

        Student student2 = new Student();
        initStudent(student2, 2, "학생2", 95, 40);

        printStudent(student1);
        printStudent(student2);
    }

    static void initStudent(Student student,
                            int number, String name, int grade, int age) {

        student.number = number;
        student.name = name;
        student.grade = grade;
        student.age = age;
    }

    static void printStudent(Student student) {
        System.out.printf("%d번: [%s] [%d 점] [%d 세]\n",
                student.number, student.name, student.grade, student.age);
    }
}
