package ch07casting;

public class Casting01Auto {
    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        
        // 작은 범위를 큰 범위타입에 대입할 시 개발자가 명시적으로 형변환할 필요가 없음
        // 컴파일 시에 자동 형변환 (컴파일러가 형변환 코드를 자동으로 삽입)
        // .class 파일에 들어가보면, 형변환 코드가 붙어있는것을 볼 수 있음 ex) longValue = (long)intValue;

        longValue = intValue;
        System.out.println("[int -> long] longValue = " + longValue);

        doubleValue = intValue; // int -> double
        System.out.println("[int -> double] doubleValue = " + doubleValue);

        doubleValue = 20000L; // int -> double
        System.out.println("[long -> double] doubleValue = " + doubleValue);


    }
}
