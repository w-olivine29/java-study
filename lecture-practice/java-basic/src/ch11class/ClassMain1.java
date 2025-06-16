package ch11class;

/**
 * 클래스: 사용자가 직접 정의하는 설계도
 *
 * 객체, 인스턴스: 클래스를 이용하여 실제 메모리에 만들어진 실체
 * 인스턴스는 어떤 클래스에 속해있는지 강조 (관계에 초점)
 *
 * new: JVM 이 Heap 메모리에 객체를 생성하는 연산자
 */
public class ClassMain1 {
    public static void main(String[] args) {

        /*
         1. Heap 메모리에 Student 타입의 실체를 만들고 해당 객체에 접근할 수 있는 참조값(주소값)을 반환
         2. student1 에 반환받은 주소값을 저장 (해당 변수는 Stack 메모리에 있음)
         */
        Student student1 = new Student();

        // 출력 시 주소값을 볼 수 있음
        // 패키지+클래스@참조값(16진수)
        System.out.println(student1); // ch11class.class1.Student@2f4d3709

        // '.'키워드: 참조값을 읽어서 객체에 접근하는 키워드
        student1.number = 1;
        student1.name = "학생1";
        student1.grade = 80;
        student1.age = 20;

        System.out.println("student1.number = " + student1.number);
        System.out.println("student1.name = " + student1.name);
        System.out.println("student1.grade = " + student1.grade);
        System.out.println("student1.age = " + student1.age);


    }
}
