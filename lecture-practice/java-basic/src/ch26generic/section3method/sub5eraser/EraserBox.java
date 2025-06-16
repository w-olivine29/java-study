package ch26generic.section3method.sub5eraser;


import ch26generic.section1necessity.step3generic.GenericBox;

/*
  타입 이레이저(Type Erasure)
  - 자바의 제네릭 타입은 컴파일 시점에만 존재하며,
    런타임 시점에는 모든 제네릭 타입 정보가 제거
  - 컴파일 후 .class 파일을 확인해보면 T는 Object 또는 상한 타입으로 대체되어 있음.
 */
public class EraserBox<T> {


    /*
      컴파일 후에는 제네릭 타입 T가 타입 이레이저에 의해 제거되고,
      내부에서는 T가 Object로 취급됨 (단, 상한 제한이 있으면 해당 타입으로 대체)

      이로 인해 런타임에 타입을 활용하는 코드 등은 작성불가
          - instanceof로 T의 타입을 확인할 수 없음
          - new T()와 같은 객체 생성도 불가능
     */
    public boolean instanceCheck(Object param) {
        //return  param instanceof T;  // -> object instanceof Object ...? -> 항상 true
        return false;
    }

    public T create(Object param) {
        //return new T(); // -> new Object()  (의도한 것과 다름)
        return null;
    }


    public static void main(String[] args) {

        /*
         자바의 제네릭은 단순하게 말하면,
         개발자가 직접 캐스팅해야 할 코드를 컴파일러가 대신 생성해주는 것과 같음.
         */

        // 제네릭 사용
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("hello");
        String str = stringBox.get(); // 컴파일러가 자동으로 String으로 캐스팅

        // 제네릭 없이 Object 사용 (개발자가 직접 캐스팅)
        GenericBox rawBox = new GenericBox();
        rawBox.set("hello");
        String rawStr = (String) rawBox.get(); // 직접 캐스팅 필요

        System.out.println("stringBox: " + str);
        System.out.println("rawBox: " + rawStr);

    }
}
