package ch05loop;

public class Loop05Nested {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("외부 for문 회차: " + i);

            for (int j = 1; j <= 3; j++) {
                System.out.println("내부 for문 " + i + "-" + j);
            }
            System.out.println("외부 for문" + i + "회차 종료\n");
        }
    }
}
