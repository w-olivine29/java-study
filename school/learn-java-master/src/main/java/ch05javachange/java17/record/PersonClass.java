package ch05javachange.java17.record;

public class PersonClass {
    private final String name;
    private final int age;

    public PersonClass(String name, int age) {
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
