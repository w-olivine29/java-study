package ch26generic.section2typebound.step2polymorphism;

import ch26generic.section2typebound.Cat;
import ch26generic.section2typebound.Wolf;

public class AnimalHospitalMain2 {
    public static void main(String[] args) {
        AnimalHospital2 catHospital = new AnimalHospital2();
        AnimalHospital2 wolfHospital = new AnimalHospital2();

        Cat cat = new Cat("치즈", 4);
        Wolf wolf = new Wolf("울프", 50);

        // Cat
        catHospital.set(cat);
        catHospital.checkup();

        // Wolf
        wolfHospital.set(wolf);
        wolfHospital.checkup();


        // 문제1: 다른 동물 전달가능
        catHospital.set(wolf); //컴파일 오류 발생 x
        catHospital.set(cat);


        // 문제2: 반환타입 다운캐스팅 필요 (ClassCastException 가능성)
        Cat moreHeavyCat = (Cat) catHospital.heavierThan(new Cat("뚱냥이", 7));
        System.out.println("moreHeavyAnimal = " + moreHeavyCat);

        /*
          - 다형성을 통해 코드 재사용성은 확보했으나, 타입 안정성 X

         next step)
               제네릭 도입을 통해 재사용성과 타입 안정성을 확보해보자
         */

    }


}
