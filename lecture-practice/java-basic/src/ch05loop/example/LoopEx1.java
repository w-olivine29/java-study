package ch05loop.example;

/* 10개의 자연수 출력
for문, while문 2가지 버전 만들기
*/
public class LoopEx1 {
    public static void main(String[] args) {

        System.out.println("=== for문 =======================");
        for (int cnt = 1; cnt <= 10; cnt++) {
            System.out.println(cnt);
        }

        System.out.println("=== while문 =======================");
        int cnt = 1;
        while (cnt <= 10) {
            System.out.println(cnt++);
        }
    }
}
