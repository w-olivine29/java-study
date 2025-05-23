package ch10method;

public class Method01_1 {


    /*
    int: 반환 타입
    add: 메서드 이름
    a,b: 파라미터(매개변수) - 메서드 호출 시 인수를 넘기면 매개변수에 대입
    {}: 수행블록(메서드 본문)
    return: 값 반환 수행

    메서드 호출 시 메모리 공간 할당 (파라미터, 수행블록 내의 변수 등)
    수행완료 후 할당받은 메모리는 해제
    */
    static int add(int a, int b) {
        System.out.printf("%d + %d 연산수행\n", a, b);
        return a + b;
    }

    public static void main(String[] args) {

        // argument(인자, 인수): 10,30 처럼 호출할 때 넘기는 값
        int result = add(10, 30); // 메서드가 반환한 결과값으로 치환
        System.out.println("result = " + result);
    }
}
