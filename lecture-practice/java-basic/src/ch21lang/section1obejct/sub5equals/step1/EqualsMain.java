package ch21lang.section1obejct.sub5equals.step1;

public class EqualsMain {
    public static void main(String[] args) {
        User user1 = new User("id-001");
        User user2 = new User("id-001");

        // 모두 false가 나오는 것을 볼 수 있다.
        System.out.println("identity: " + (user1 == user2));
        System.out.println("equality: " + (user1.equals(user2))); // Object의 equals -> return (this == obj);
    }

}
