package ch01lambda.sub1whylambda.step1valueparameterization;

// 변하는 문자열 데이터를 매개변수를 통해 외부에서 전달받기 (변하지 않는 부분은 그대로 유지)
// 핵심은 변하는 부분과 변하지 않는 부분을 분리하는 것
public class Ex0RefMain {

    public static void hello(String str) {
        System.out.println("프로그램 시작"); // 변하지 않는 부분

        // 변하는 부분 시작
        System.out.println("Hello " + str);
        // 변하는 부분 종료

        System.out.println("프로그램 종료\n"); // 변하지 않는 부분
    }

    public static void main(String[] args) {
        hello("Java");
        hello("Spring");
    }
}
/* 값 매개변수화
문자값, 숫자값 처럼 구체적인 값을 메서드 안에 두는 것이 아닌, 매개변수를 통해 외부에서 받게끔하여, 
메서드 동작을 달리하고 재사용성을 높이는 방법
*/
