package ch14consturct.before;

public class Member {

    String name;
    int age;
    int grade;

    // 캡슐화: 속성과 기능을 한 클래스에 묶고 기능을 외부에 메서드로 제공
    void initMember(String name, int age, int grade) {

        // 매개변수와 멤버변수이름이 동일할 경우, 매개변수로 인식 (더 가까운 스코프가 우선순위)
        // 이 경우 멤버변수에 접근하려면 this(인스턴스 자신의 참조값) 를 사용
        // 이름이 상이하다면 선택사항
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
