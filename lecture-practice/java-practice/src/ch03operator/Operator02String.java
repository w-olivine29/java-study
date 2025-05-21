package ch03operator;

public class Operator02String {

    public static void main(String[] args) {

        // String 에 다른 타입을 더하는 경우 대상 타입을 String화
        
        System.out.println("====== 문자열 + 문자열 (1) =================================");
        String strResult1 = "Java" + "Java";
        System.out.println("strResult1 = " + strResult1); //JavaJava

        System.out.println("====== 문자열 + 문자열 (2) =================================");
        String str1 = "Java1";
        String str2 = "Java2";
        System.out.println("str1 + str2 = " + str1 + str2); //Java1Java2

        System.out.println("====== 문자열 + 숫자 (1) =================================");
        String numResult1 = "10" + 1; //101
        System.out.println("numResult = " + numResult1);

        System.out.println("====== 문자열 + 숫자 (2) =================================");
        String str = "11";
        int num = 9;
        System.out.println("str + num = " + str + num); //119
    }
}
