package ch07annotation.step5validator.after;

public class User {

    @NotEmpty(message = "유저 이름이 비었습니다.")
    private String name;

    @Range(min=1, max = 100, message = "나이제한 1 ~ 100세")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
