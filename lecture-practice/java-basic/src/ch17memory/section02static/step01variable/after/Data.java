package ch17memory.section02static.step01variable.after;

// static 변수 사용
public class Data {

    // 멤버변수(필드)
    public String name; // 인스턴스 변수
    public static int count; // 정적변수, 클래스변수, static변수 (클래스 자체에 소속)

    public Data(String name) {
        this.name = name;
        count++;
    }
}
