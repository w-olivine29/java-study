package ch06methodreference.sub2;

public class Person {

    private String name;

    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        this.name = name;
    }


    // 정적 메서드 , (매개변수 x)
    public static String greeting() {
        return "안녕하세요";
    }

    // 정적 메서드 , (매개변수 o)
    public static String greetingWithNames(String name) {
        return String.format("안녕하세요, %s님", name);
    }

    public String getName() {
        return name;
    }

    // 인스턴스 메서드 (매개변수 x)
    public String introduceWithNumber() {
        return String.format("제 이름은 %s 입니다.", this.name);
    }

    // 인스턴스 메서드 (매개변수 o)
    public String introduceWithNumber(int number) {
        return String.format("제 이름은 %s, 번호는 %d 입니다.", this.name, number);
    }

}
