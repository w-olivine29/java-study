package optionaltask.task1;

// 41기 유도경
public class JsonMain {
    public static void main(String[] args) {
        Person person1 = new Person("회원1", 30, "F", false);
        Person person12 = new Person("회원2", 40, "M", true);

        System.out.println(JsonSerializer.toJson(person1));
        System.out.println(JsonSerializer.toJson(person12));
    }
}
