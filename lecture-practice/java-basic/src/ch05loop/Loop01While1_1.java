package ch05loop;

public class Loop01While1_1 {
    public static void main(String[] args) {

        System.out.println("\n== 전위 연산자 사용 ==========");
        int cnt = 0;
        while (cnt < 3) {
            System.out.println("현재 카운트: " + ++cnt); //1~3
        }

        System.out.println("\n== 후위 연산자 사용 ==========");
        cnt = 0;
        while (cnt < 3) {
            System.out.println("현재 카운트: " + cnt++); //0~2
        }
    }
}
