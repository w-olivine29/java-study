package ch13oop.example.ex1;

/* 직사각형의 넓이, 둘레길이, 정사각형 여부 구하기

주어진 예제(절차지향방식) -> 객체 지향 프로그래밍 변경
 */
public class RectangleOopMain {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle();
        rectangle1.width = 10;
        rectangle1.height = 20;

        Rectangle rectangle2 = new Rectangle();
        rectangle2.width = 30;
        rectangle2.height = 30;


        rectangle1.printRectangleInfo();
        rectangle2.printRectangleInfo();

    }


}
