package ch14consturct.after.overloading;


public class Member {

    String name;
    int age;
    int grade;

    /*
    다른 생성자와 중복되는 부분은 this() 사용할 수 있음
    생성자 내에서 자신의 다른 생성자를 호출할 수 있음
    this()는 생성자 코드의 첫줄에만 작성가능
    생성자내에서 다른 생성자 명시적 호출은 한번 만 가능
    */
    public Member(String name) {
        this.name = name;
    }

    public Member(String name, int age) {

        //Call to 'this()' must be first statement in constructor body
//        this.age = age;
//        this(name);

        this(name);
        this.age = age;
    }

    public Member(String name, int age, int grade) {

        this(name, age);

        // Only one explicit constructor call allowed in constructor
        //this(name, age);

        this.grade = grade;
    }

    /*
    이런식으로 계속 연결되는 생성자 체이닝 구조의 경우,
    너무 길어지면, 흐름을 파악하기가 어려울 수 있음
     */
}
