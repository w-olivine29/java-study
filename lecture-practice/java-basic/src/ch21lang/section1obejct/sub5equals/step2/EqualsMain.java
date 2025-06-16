package ch21lang.section1obejct.sub5equals.step2;

public class EqualsMain {
    public static void main(String[] args) {
        User user1 = new User("id-001");
        User user2 = new User("id-001");

        System.out.println("identity: " + (user1 == user2)); //false
        System.out.println("equality: " + (user1.equals(user2))); // true (필드값을 비교하는 것으로 재정의)
    }

}
