package ch26generic.section2typebound.step4typebound;

import ch26generic.section2typebound.Cat;
import ch26generic.section2typebound.Wolf;

public class AnimalHospitalMain4 {
    public static void main(String[] args) {
        AnimalHospital4<Cat> catHospital = new AnimalHospital4<>();
        catHospital.set(new Cat("치즈", 4));
        //catHospital.set(new Wolf("울프", 50)); //컴파일 오류
        
        AnimalHospital4<Wolf> wolfHospital = new AnimalHospital4<>();
        wolfHospital.set(new Wolf("울프", 50));


        // Integer extends Animal? -> x
        //AnimalHospital4<Integer> integerAnimalHospital = new AnimalHospital4<>();
     
        
        // Animal의 기능 사용가능
        catHospital.checkup();
        wolfHospital.checkup();



        Cat moreHeavyCat = catHospital.heavierThan(new Cat("뚱냥이", 7));


        System.out.println("moreHeavyAnimal = " + moreHeavyCat);

        /*
        <T extends Animal>
          - 타입 매개변수에 들어갈 수 있는 상한을 지정
              - Animal 과 상관없는 타입 인자는 컴파일 오류
              - 제네릭 클래스 정의 시점에 Animal의 기능 사용 가능
         */

    }


}
