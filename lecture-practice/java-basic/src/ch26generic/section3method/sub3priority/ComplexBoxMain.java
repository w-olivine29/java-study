package ch26generic.section3method.sub3priority;

import ch26generic.section3method.Cat;
import ch26generic.section3method.Wolf;

public class ComplexBoxMain {
    public static void main(String[] args) {

        Cat cat1 = new Cat("치즈", 6);
        Wolf wolf1 = new Wolf("늑댕댕", 60);

        ComplexBox<Cat> catComplexBox = new ComplexBox<>();
        catComplexBox.set(cat1);

        Wolf resultWolf = catComplexBox.printAndReturn(wolf1);
        System.out.println("resultWolf = " + resultWolf);
    }
}
