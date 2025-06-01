package ch21lang.section3wrapper.sub2javawapper.step3method;

// 다른 wrapper 클래스들도 제공
public class WrapperUtilsMain {
    public static void main(String[] args) {

        // int -> Integer
        Integer int1 = Integer.valueOf(10);

        // String -> Integer, int
        Integer int2 = Integer.valueOf("20"); // return Integer.valueOf(parseInt(s, 10));  두번째 인수는 진수
        int int3 = Integer.parseInt("30");

        // 비교
        int compareResult = int1.compareTo(30);
        System.out.println("compareResult = " + compareResult); //-1

        // 산술 연산
        System.out.println("Integer.sum(10,30) -> " + Integer.sum(10, 30)); //40
        System.out.println("Integer.max(10,30) -> " + Integer.max(10, 30)); //30
        System.out.println("Integer.min(10,30) -> " + Integer.min(10, 30)); //10
    }
}
