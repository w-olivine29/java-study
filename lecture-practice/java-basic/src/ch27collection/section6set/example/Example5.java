package ch27collection.section6set.example;

import java.util.HashSet;

/* Equals, HashCode
실행결과를 참고하여, Rectangle 클래스 완성
Rectangle 클래스는 width, height 모두가 같으면 같은 값으로 정의
*/
public class Example5 {
    public static void main(String[] args) {
        HashSet<Rectangle> set = new HashSet<>();
        set.add(new Rectangle(30, 30));
        set.add(new Rectangle(50, 50));
        set.add(new Rectangle(50, 50));
        set.add(new Rectangle(20, 30));

        for (Rectangle rectangle : set) {
            System.out.println(rectangle);
        }
    }
}
