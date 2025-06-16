package ch21lang.section2string.section5mutable.sub2optimization;

//String 최적화
public class LoopStringMain {
    public static void main(String[] args) {

        //자바의 String 최적화 방식 (컴파일 단계에서 최적화 -> 런타임 시에 문자열 결합 연산 수행 x)
        //버전마다 방식은 다를 수 있음

        // 리터럴 (하나의 문자열로 최적화)
        System.out.println("문자" + "문자" + "문자" + "문자" + "문자" + "문자" + "문자");
        // 컴파일러가 "문자문자문자문자문자문자문자" 이런식으로 최적화

        //변수 (가변객체 사용으로 최적화)
        String str = "문자";
        System.out.println(str + str + str + str + str);
        /*
         * StringBuilder sb = new StringBuilder();
         * sb.append(str).append(str).append(str).append(str).append(str).toString()
         * */

        /* 위와 같은 대부분의 상황에선 컴파일러가 최적화를 해주므로  + 연산해도 좋다.
        * 최적화가 어려운 경우에는 StringBuilder or StringBuffer(멀티쓰레드용) 사용
        * 
        * 최적화가 어려운 경우 예시
        * - 반복문에서 반복연산
        * - 조건문을 통한 동적 문자열 연산
        * - 복잡한 문자열의 특정부분 변경
        * - 매우 긴 대용량 문자열 연산
        * */


        // 문자열 연산 성능 비교
        //stringLoopTime("Hello Java, ", 100_000); // 8~9초
        stringBuilderLoopTime("Hello Java, ", 100_000); // 0.002초
    }

    // 반복문 or 조건문 등의 상황에서는 컴파일러가 예측하기 힘들때문에 최적화가 어려움
    private static void stringLoopTime(String string, int loopCount) {
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < loopCount; i++) {
            result += string;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("result = " + result);

        System.out.printf("stringLoopTime: %.1f second", (endTime - startTime) / 1000.0);
    }

    private static void stringBuilderLoopTime(String string, int loopCount) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loopCount; i++) {
            sb.append(string);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("result = " + sb.toString());

        System.out.printf("stringLoopTime: %.3f second", (endTime - startTime) / 1000.0);
    }
}
