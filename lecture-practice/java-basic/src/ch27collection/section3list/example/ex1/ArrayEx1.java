package ch27collection.section3list.example.ex1;

/* 문제1- 배열을 리스트로 변경하기
다음 코드와 실행 결과를 참고하여, ListEx1 클래스 만들기
*/
public class ArrayEx1 {
    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};

        int total = 0;
        for (int i = 0; i < students.length; i++) {
            total += students[i];
        }

        double average = (double) total / students.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}