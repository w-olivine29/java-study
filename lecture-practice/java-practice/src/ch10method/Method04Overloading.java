package ch10method;

/**
 * 자바는 이름뿐만 아니라 매개변수 정보까지 포함해서 메서드를 구분
 * 메서드 시그니쳐가 다르면 다른 메서드로 간주
 * <p>
 * 메서드 시그니쳐 (메서드를 구분하는 기준)
 * 메서드 이름 + 매개변수의 타입, 개수, 순서
 * <p>
 * 메서드 오버로딩: 이름은 같고 매개변수가 다른 메서드를 여러개 정의
 * <p>
 * 반환 타입은 오버로딩을 구분짓는 기준 X
 */
public class Method04Overloading {


    static int add(int num1, int num2) {
        System.out.println("add(int num1, int num2) 호출");
        return num1 + num2;
    }

    // 파라미터 타입
    static double add(double num1, int num2) {
        System.out.println("add(double num1, int num2) 호출");
        return num1 + num2;
    }


    // 파라미터 순서
    static double add(int num1, double num2) {
        System.out.println("add(int num1, double num2) 호출");
        return num1 + num2;
    }

    // 파라미터 개수
    static int add(int num1, int num2, int num3) {
        System.out.println("add(int num1, int num2, int num3) 호출");
        return num1 + num2 + num3;
    }

    static long add(long num1, long num2, long num3, long num4) {
        System.out.println("add(long num1, long num2, long num3, long num4) 호출");
        return num1 + num2 + num3 + num4;
    }


    public static void main(String[] args) {

        add(1, 2);
        add(1.0, 2);
        add(1, 2.0);
        add(1, 1, 1);

        // 본인 타입에 가장 적합한 것을 먼저 호출
        // 적합한 것이 없다면 자동 형변환되어 호출됨
        add(1,1,1,1); // int -> long 자동형변환

        
    }
}
