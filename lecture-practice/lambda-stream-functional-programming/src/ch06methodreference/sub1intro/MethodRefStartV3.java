package ch06methodreference.sub1intro;

import java.util.function.BinaryOperator;

// 메서드 참조 적용
public class MethodRefStartV3 {
    public static void main(String[] args) {

        BinaryOperator<Integer> add1 = MethodRefStartV3::add; //(x, y) -> add(x, y)
        BinaryOperator<Integer> add2 = MethodRefStartV3::add;

        Integer result1 = add1.apply(1, 2);
        System.out.println("result1 = " + result1);

        Integer result2 = add2.apply(1, 2);
        System.out.println("result2 = " + result2);
    }

    static int add(int x, int y){
        return x + y;
    }
}
/* 
클래스::메서드명
(x,y) -> add(x, y)  =   MethodRefStartV3::add

- 코드가 더욱 간결, 가독성 향상
- 매개변수를 명시적으로 작성할 필요가 없어짐 (컴파일러가 자동으로 매개변수 매칭)
- 별도의 로직 분리와 함께 재사용성 또한 높아짐


메서드 참조란
이미 정의된 메서드를 그대로 참조하여 람다 표현식을 더 간결하게 작성하는 방법
*/