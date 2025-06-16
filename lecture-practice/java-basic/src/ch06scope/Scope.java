package ch06scope;

public class Scope {
    public static void main(String[] args) {
        int m = 10; //생존시작

        if (m < 10) {
            int x = 30; // 생존시작
            System.out.println(m++);
            System.out.println(x);
        } // x 생존종료
        System.out.println(m);
        //System.out.println(x);

        for (int i = 0; i < 10; i++) { // i 생존시작
            System.out.println(m);
            System.out.println(i);
        }
        // i 생존종료

    } //m 생존종료
    
}
