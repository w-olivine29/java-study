package ch26generic.section3method.sub4wildcard;


import ch26generic.section3method.*;

public class WildCardMain3_LowerBound {
    public static void main(String[] args) {

        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        Box<Wolf> wolfBox = new Box<>();


        writeBox(objBox);
        writeBox(animalBox);
        
        // Animal 보다 하위인 클래스는 불가
//        writeBox(catBox);
//        writeBox(wolfBox);
    }


    // Animal 포함 상위타입 전달 가능 (Animal이 하한)
    static void writeBox(Box<? super Animal> box) {
        System.out.println("box 안에는 무엇이 있나: " + box.get());
    }

    /* 하한 와일드카드는 제네릭에는 사용할 수 없다 */
}
