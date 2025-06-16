package ch13oop.example.ex1;

/**
 * 속성: 너비, 높이
 * 기능)
 * 넓이 구하기
 * 둘레 길이 구하기
 * 정사각형 여부 구하기
 */
public class Rectangle {

    int width;
    int height;

    int calculateArea() {
        return width * height;
    }

    int calculatePerimeter() {
        return (width + height) * 2;
    }

    boolean isSquare() {
        return width == height;
    }


    void printRectangleInfo() {

        int area = calculateArea();
        int perimeter = calculatePerimeter();
        String shapeType = isSquare() ? "정사각형" : "직사각형";

        System.out.printf(
                "가로길이: %d, 세로길이: %d, 넓이: %d, 둘레: %d, 모양타입: %s\n",
                width, height, area, perimeter, shapeType);
    }
}
