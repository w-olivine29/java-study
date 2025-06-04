package ch24nestedclasses.section3local.sub2anonymous.step2example;

import java.util.Random;

public class Refactoring1 {

    public static void hello(Processor processor) {
        System.out.println("start program"); //변하지 않는 부분
        processor.run(); //변하는 부분
        System.out.println("end program"); //변하지 않는 부분
    }

    public static void main(String[] args) {

        // 미리 구현해둔 클래스 넘기기
        hello(new Dice());
        hello(new Sum());


        // 익명클래스로 넘기기
        hello(new Processor() {
                  @Override
                  public void run() {
                      int randomValue = new Random().nextInt(1, 7);
                      System.out.println("result: " + randomValue);
                  }
              }
        );

        hello(new Processor() {
                  @Override
                  public void run() {
                      for (int i = 0; i < 3; i++) {
                          System.out.println("i = " + i);
                      }
                  }
              }
        );
    }

    /*
     [생각의 흐름 정리]

     1. 공통되는 코드는 메서드 안에 그대로 둔다.
        → 즉, 변하지 않는 부분은 유지

     2. 변하는 부분만 따로 분리
        → 메서드 안에 다른 코드를 동적으로 넣을 방법이 필요

     3. 하지만 자바는 메서드를 직접 변수처럼 전달할 수 없다.
        → 해결책: 메서드를 가진 클래스를 만들고, 그 인스턴스를 넘기기

     4. 같은 이름의 메서드를 상황에 따라 다르게 실행하고 싶다.
        → 방법: 다형성을 활용한다.

     5. 결론:
        - 인터페이스를 정의하고
        - 메서드의 매개변수로 해당 인터페이스 타입을 받는다.
        - 변하는 코드는 인터페이스를 구현한 클래스로 분리
    */
}


class Dice implements Processor {
    @Override
    public void run() {
        int randomValue = new Random().nextInt(1, 7);
        System.out.println("result: " + randomValue);
    }
}

class Sum implements Processor {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }
    }
}