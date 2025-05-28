package ch20polymorphism.section2.sub1abstract.step3abstract1;


public class BirdSoundMain {
    public static void main(String[] args) {

        //Bird bird = new Bird(); //'Bird' is abstract; cannot be instantiated (인스턴스 생성불가)

        Bird sparrow = new Sparrow();
        Bird crow = new Crow();
        Bird parrot = new Parrot();

        Bird[] birds = {new Sparrow(), new Crow(), new Parrot()};

        for (Bird bird : birds) {
            soundBird(bird);
            fly(bird);
            System.out.println();
        }

    }

    private static void soundBird(Bird bird) {
        System.out.println("bird sound test start");
        bird.sound();  // 오버라이딩 된 추상메서드
        System.out.println("bird sound test end");
    }

    private static void fly(Bird bird) {
        System.out.println("bird flying test start");
        bird.fly();
        System.out.println("bird flying test end");
    }

}
