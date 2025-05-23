package ch10method;

// 각각의 메서드 안에서 사용하는 변수는 서로 분리된 지역변수 (서로 다른 영역에 생성)
// 이름이 같아도 다른 공간에 생성된 다른 변수
public class Method02Value2_2 {

    public static void main(String[] args) {

        int num = 10;
        System.out.println("1. before changeNumber num = " + num);

        changeNumber(num);
        System.out.println("num = " + num); // main 메서드 안의 num은 그대로

    }

    static void changeNumber(int num) {
        System.out.println("2. before changeNumber num = " + num); // 10
        num *= 2;
        System.out.println("3. after changeNumber num = " + num); //20

    }


}
