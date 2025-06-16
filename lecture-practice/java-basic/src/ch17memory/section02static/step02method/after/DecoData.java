package ch17memory.section02static.step02method.after;

public class DecoData {
    private int instanceValue;
    private static int staticValue;


    public void instanceCall() {
        System.out.println("DecoData.instanceCall");

        // 인스턴스 요소에 접근 가능
        instanceValue++;
        instanceMethod();

        staticValue++; //정적 변수 접근
        staticMethod(); // 정적 메서드 호출
    }

    public static void staticCall1() {
        System.out.println("DecoData.staticCall1");

        // 인스턴스 요소에 접근불가 (컴파일 에러)
        // 인스턴스는 참조값을 통해서 접근가능한데, 참조값이 없는 상태
//        instanceValue++;
//        instanceMethod();

        staticValue++; //정적 변수 접근
        staticMethod(); // 정적 메서드 호출
    }


    public static void staticCall2(DecoData decoData) {
        System.out.println("DecoData.staticCall2");

        // 인스턴스를 직접받은 것은 접근 가능
        decoData.instanceValue++;
        decoData.instanceMethod();

    }

    private void instanceMethod() {
        System.out.println("DecoData.instanceMethod");
    }

    private static void staticMethod() {
        System.out.println("DecoData.staticMethod");
    }
}
