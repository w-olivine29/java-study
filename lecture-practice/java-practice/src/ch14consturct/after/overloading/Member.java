package ch14consturct.after.overloading;


public class Member {

    String name;
    int age;
    int grade;


    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member(String name, int age, int grade) {

        this.name = name;
        this.age = age;
        this.grade = grade;
    }

}
