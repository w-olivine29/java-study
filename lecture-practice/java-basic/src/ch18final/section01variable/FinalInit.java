package ch18final.section01variable;

/*
 final 인스턴스 변수의 경우 필드 선언 동시에 값을 할당하거나
 생성자를 통해서라도 값을 할당해줘야함

 JVM이 final에 대해서는 자동 초기화를 하지 않기 때문에, 객체가 생성되기 전에 값이 확정되어야 하며,
 한 번 초기화된 후에는 값을 변경할 수 없기 때문

 static final (상수)
 자바에서는 하나만 존재하는 변하지 않는 고정된 값을 뜻함
*/
public class FinalInit {


    final int constructInitValue; // 생성자 초기화


    // 인스턴스마다 다를 필요가 없는 값인데, 모든 인스턴스에 값이 중복 -> 메모리 낭비
    // 이런 경우는 상수로 만들기 (static final)
    final int filedInitValue = 10;


    static final int CONST_VALUE = 100; // static final -> 상수 (대문자)


//  public FieldInit(int value) {
//        this.filedInitValue = value; //클래스 자체에서 이미 값을 할당한 final 이기때문에 새로 대입불가
//    }


    public FinalInit(int value) {  // 인스턴스마다 다른 값을 가지기때문에 final '변수' 로써의 의미가 있음
        constructInitValue = value;
    }
}
