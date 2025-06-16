package ch14consturct.after.intro;

public class MemberDefault {
    String name;

    // 기본생성자: 매개변수가 없고, 자동제공 or 명시적으로 작성한 생성자
    // 직접 정의한 생성자가 하나라도 있다면 컴파일러는 기본 생성자를 제공해주지 않음 (필요 시 명시적으로 만들어줘야함)
    public MemberDefault(String name) {
        System.out.println("직접 정의한 생성자 호출");
    }
}
