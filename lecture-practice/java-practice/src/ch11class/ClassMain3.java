package ch11class;


public class ClassMain3 {
    public static void main(String[] args) {


        Student student1 = new Student();
        student1.number = 1;
        student1.name = "학생1";
        student1.grade = 80;
        student1.age = 20;

        Student student2 = new Student();
        student2.number = 2;
        student2.name = "학생2";
        student2.grade = 90;
        student2.age = 22;

        Student[] students = {student1, student2};

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.printf("%d번: [%s] [%d 점] [%d 세]\n",
                    student.number, student.name, student.grade, student.age);
        }

        System.out.println("============= 향상된 for문 =============");
        for (Student student : students) {
            System.out.printf("%d번: [%s] [%d 점] [%d 세]\n",
                    student.number, student.name, student.grade, student.age);
        }


    }
}
