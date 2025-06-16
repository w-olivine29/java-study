package ch14consturct.after.intro;


public class Member {

    String name;
    int age;
    int grade;

    public Member(String name, int age, int grade) {

        System.out.printf("[생성자 호출]이름: %s, 나이: %d, 점수: %d \n", name, age, grade);

        this.name = name;
        this.age = age;
        this.grade = grade;
    }

}
