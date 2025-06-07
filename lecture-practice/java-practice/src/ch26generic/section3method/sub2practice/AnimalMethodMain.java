package ch26generic.section3method.sub2practice;


import ch26generic.section3method.*;

public class AnimalMethodMain {
    public static void main(String[] args) {

        Cat cat1 = new Cat("치즈", 4);
        Cat cat2 = new Cat("먼지", 5);

        Wolf wolf1 = new Wolf("검댕이", 50);
        Wolf wolf2 = new Wolf("은빛갈기", 60);


        // 타입 추론
        AnimalMethod.checkup(cat1);
        AnimalMethod.checkup(cat2);
        Cat heavierCat = AnimalMethod.heavierThan(cat1, cat2);
        System.out.println("heavierCat = " + heavierCat);

        AnimalMethod.checkup(wolf1);
        AnimalMethod.checkup(wolf2);
        Wolf heavierWolf = AnimalMethod.heavierThan(wolf1, wolf2);
        System.out.println("heavierWolf = " + heavierWolf);


        Animal heavierAnimal = AnimalMethod.<Animal>heavierThan(cat1, wolf2);
        System.out.println("heavierAnimal = " + heavierAnimal);


    }


}
