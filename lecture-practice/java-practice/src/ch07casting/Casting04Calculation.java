package ch07casting;

public class Casting04Calculation {

    public static void main(String[] args) {
        int div1 = 3 / 2; // 1.5(x) , 1(o)
        System.out.println("div1 = " + div1);

        double div2 = 3 / 2; // 1.5(x) , 1(o)
        System.out.println("div2 = " + div2); //1.0
        // double div2 = (double)(3 / 2); 계산 후 1이라는 int 결과가 나온 후 double 형변환돼버린 것


        double div3 = (double) 3 / 2;
        System.out.println("div3 = " + div3); // 1.5
        // 서로 다른 타입의 계산은 큰 범위로 자동 형변환
        // -> (double) 3 / (double) 2   int였던 2가 double로 자동 형변환 후 계산

    }
}
