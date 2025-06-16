package ch12reference;

public class Ref03Method2 {
    public static void main(String[] args) {

        Student student1 = createStudent(1, "학생1", 80, 20);
        printStudent(student1);

        Student student2 = createStudent(2, "학생2", 95, 40);
        printStudent(student2);
    }

    static Student createStudent(int number, String name, int grade, int age) {
        Student student = new Student();
        System.out.println("student 인스턴스 생성: " + student);

        student.number = number;
        student.name = name;
        student.grade = grade;
        student.age = age;

        return student; // 주소값 반환
    }


    static void printStudent(Student student) {

        System.out.print("student 정보 출력 -> ");
        System.out.print("인스턴스 주소값: " + student);
        System.out.printf(" [%d번] [%s] [%d 점] [%d 세]\n",
                student.number, student.name, student.grade, student.age);
    }
}
