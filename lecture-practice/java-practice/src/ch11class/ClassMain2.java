package ch11class;


public class ClassMain2 {
    public static void main(String[] args) {

        Student[] students = new Student[2];

        Student student1 = new Student();
        student1.number = 1;
        student1.name = "학생1";
        student1.grade = 80;
        student1.age = 20;

        Student student2 = new Student();
        student2.number = 2;
        student2.name = "학생2";
        student2.grade = 100;
        student2.age = 22;

        // 자바에서의 대입은 항상 변수에 들어 있는 값을 복사해서 전달한다.
        // 각 변수에 있는 참조값을 복사해서 배열에 대입
        students[0] = student1;
        students[1] = student2;


    }
}
