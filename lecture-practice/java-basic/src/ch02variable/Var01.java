package ch02variable;

public class Var01 {
    public static void main(String[] args) {

        System.out.println("==========================");
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);

        System.out.println(2);
        System.out.println(2);
        System.out.println(2);

        System.out.println("==========================");
        int var1; // 변수 선언
        var1 = 100;
        // 100을 var1에 대입 (변수 초기화),  =: equals x
        // 변수 초기화: 선언한 변수에 처음으로 값을 대입하여 저장하는 것
        System.out.println(var1);

        System.out.println("==========================");
        int var2 = 100; // 변수 선언 & 초기화
        System.out.println(var2);

        var2 = 200; // 변수 값 변경 (100 -> 200)
        System.out.println(var2);

        System.out.println("==========================");
        int var3 = 300, var4 = 400; // 동시에 여러 변수 선언 & 초기화

        int var5, var6 = 500600; // 동시에 선언 & var6만 초기화
        //System.out.println(var5); // 컴파일에러 발생 - might not have been initialized
        System.out.println(var6);

    }
}
