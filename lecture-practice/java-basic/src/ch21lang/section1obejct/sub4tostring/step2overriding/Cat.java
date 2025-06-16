package ch21lang.section1obejct.sub4tostring.step2overriding;

public class Cat {

    private String name;
    private int age;

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
