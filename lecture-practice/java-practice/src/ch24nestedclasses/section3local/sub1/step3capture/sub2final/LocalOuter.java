package ch24nestedclasses.section3local.sub1.step3capture.sub2final;

import java.lang.reflect.Field;

public class LocalOuter {

    private int outerInstanceVar = 10;


    public Printer process(int paramVar) {

        // 직접 final로 선언하지않아도, 사실상 final
        final int localVar = 20;

        class LocalPrinter implements Printer {
            int value = 30;

            @Override
            public void print() {
                System.out.println("value = " + value);

                //Variable 'localVar' is accessed from within inner class, needs to be final or effectively final
                System.out.println("localVar = " + localVar);

                System.out.println("paramVar = " + paramVar);
                System.out.println("outerInstanceVar = " + outerInstanceVar);

            }
        }

        LocalPrinter localPrinter = new LocalPrinter(); //해당 클래스에서 접근하는 지역변수(localVar, paramVar) 캡쳐

        // LocalPrinter(지역클래스)에서 캡처한 지역변수의 값을 변경 시 -> 인스턴스에 캡처한 변수의 값이 달라짐
        // localVar = 10;

     /* 동기화문제 발생
        - 지역변수 변경 -> 다시 캡쳐해야함
        - 캡쳐한 값 변경 -> 지역변수 값 변경해야함

        이는 사이드이펙트 발생 가능성 매우 높고, 디버깅도 어려움
        멀티쓰레드 상황에서의 동기화는 더더욱 어렵다.
    */

        return new LocalPrinter();
    }

    public static void main(String[] args) {
        LocalOuter outer = new LocalOuter();
        Printer localPrinter = outer.process(0); // 지역클래스 반환
        localPrinter.print(); // 지역클래스의 메서드를 외부에서 호출


        System.out.println("==== 선언된 필드 확인 ====");
        for (Field field : localPrinter.getClass().getDeclaredFields()) {
            System.out.println(field);
        }

    }
}
