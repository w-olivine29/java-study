package ch26generic.section2typebound.step3failedgeneric;

import ch26generic.section2typebound.Cat;
import ch26generic.section2typebound.Wolf;

public class AnimalHospitalMain3 {
    public static void main(String[] args) {
        AnimalHospital3<Cat> catHospital = new AnimalHospital3<>();
        catHospital.set(new Cat("치즈", 4));

        AnimalHospital3<Wolf> wolfHospital = new AnimalHospital3<>();
        wolfHospital.set(new Wolf("울프", 50));


        // 전혀 관계없는 타입 인자 전달 가능 (클래스 의도와 맞지않음)
        AnimalHospital3<Integer> integerHospital = new AnimalHospital3<>();
        AnimalHospital3<Object> objectHospital = new AnimalHospital3<>();

        

        
        /*
          - 제네릭을 도입함으로써, 어떤 타입이든 객체 생성 시점에 결정할 수 있게되었으나
            의도와는 전혀 관계없는 타입인자 전달 가능

          - 클래스 정의 시점에서는 T의 타입을 알 수 없기 때문에 Object 외의 기능 사용불가

         next step)
            모든 타입이 아닌 Animal 이나 그 자식 타입 인자로 제한할 필요가 있다
            -> 제네릭 타입 매개변수 제한
         */

    }


}
