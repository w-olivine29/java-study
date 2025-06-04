package ch24nestedclasses.section3local.sub1.step3capture.sub1;

import java.lang.reflect.Field;

public class LocalOuter {

    private int outerInstanceVar = 10;


    /*
    참고) LocalPrinter를 반환타입으로 직접 선언할 수는 없음
          LocalPrinter 클래스는 지역클래스이기때문에, 메서드 바깥에서는 접근불가
          -> 해당 메서드의 반환타입으로 선언불가
     */
    public Printer process(int paramVar) {

        // 지역변수 - 스택프레임 종료 시 함께 제거
        int localVar = 20;

        class LocalPrinter implements Printer {
            int value = 30;

            @Override
            public void print() {
                System.out.println("value = " + value);

                // 인스턴스는 지역변수보다 더 오래 살아남음
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outerInstanceVar = " + outerInstanceVar);

            }
        }

        LocalPrinter localPrinter = new LocalPrinter();
        //localPrinter.print(); 여기서 실행x, Printer 만 반환하고 외부에서 호출

        return new LocalPrinter(); // 지역클래스로 만든 객체도 인스턴스이기때문에 Heap 영역에 존재하게 됨
    }

    public static void main(String[] args) {
        LocalOuter outer = new LocalOuter();
        Printer localPrinter = outer.process(0); // 지역클래스 반환
        localPrinter.print(); // 지역클래스의 메서드를 외부에서 호출


        /*
         지역클래스 내의 메서드를 밖에서 호출
         스택에 있는 process() 프레임이 사라진 이후에 호출
         스택 프레임이 사라져도 localPrinter 라는 참조변수가 있는 한 LocalPrinter인스턴스는 Heap 영역에 남아있음 (main() 이 종료될때까지 생존)
         -> 그래서 밖에서도 localPrinter.print() 호출가능

         localPrinter.print() 안의 지역변수에 접근하는 코드는 어떻게 실행되는가? (지역변수는 해당 메서드가 실행되는 동안에만 생존하는데?)
         -> [변수 캡처]
            - 지역클래스의 인스턴스를 생성하는 시점에 접근이 필요한 지역 변수를 복사해서 인스턴스에 함께 넣어둠
            - 지역클래스의 메서드 실행 중 접근하는 지역변수들은, 사실 지역변수에 접근하는 것이 아닌, 인스턴스에 있는 캡처한 변수에 접근하는 것
        */

        System.out.println("==== 선언된 필드 확인 ====");
        for (Field field : localPrinter.getClass().getDeclaredFields()) {
            System.out.println(field);
        }
        //예상) 필드니까 int value 하나만 나온다? -> x


        /* 선언된 필드 확인
         
        직접 선언해놓은 멤버변수
            int 패키지경로.LocalOuter$1LocalPrinter.value

        캡쳐 변수
            final int 패키지경로.LocalOuter$1LocalPrinter.val$localVar
            final int 패키지경로.LocalOuter$1LocalPrinter.val$paramVar

        바깥 클래스를 참조하기 위한 필드
            final 패키지경로.LocalOuter$1LocalPrinter.this$0
        */
    }
}
