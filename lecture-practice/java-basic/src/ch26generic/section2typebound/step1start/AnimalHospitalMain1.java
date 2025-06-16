package ch26generic.section2typebound.step1start;

import ch26generic.section2typebound.*;

public class AnimalHospitalMain1 {
    public static void main(String[] args) {
        CatHospital catHospital = new CatHospital();
        WolfHospital wolfHospital = new WolfHospital();

        Cat cat = new Cat("치즈", 4);
        Wolf wolf = new Wolf("울프", 50);

        // CatHospital
        catHospital.set(cat);
        catHospital.checkup();

        // WolfHospital
        wolfHospital.set(wolf);
        wolfHospital.checkup();


        Cat moreHeavyCat = catHospital.heavierThan(new Cat("뚱냥이", 7));
        System.out.println("moreHeavyCat = " + moreHeavyCat);


        /*
        각 타입에 맞는 별도의 클래스 정의해서 사용
        CatHospital - Cat , WolfHospital - Wolf
          - 코드 재사용 X
          - 타입 안정성 o

         next step) 다형성을 활용해서 코드 재사용성을 확보해보자
         */
    }

}
