package ch20polymorphism.section2.sub2interface.step3hybrid;


public class BirdSoundMain {
    public static void main(String[] args) {

        //Bird bird = new Bird(); //'Bird' is abstract; cannot be instantiated (인스턴스 생성불가)

        Bird duck = new Duck();
        Bird parrot = new Parrot();
        Bird penguin = new Penguin();
        Bird kiwi = new Kiwi();

        Bird[] birds = {new Penguin(), new Duck(), new Parrot()};

        for (Bird bird : birds) {
            soundBird(bird);
            fly(bird);
            swim(bird);
            System.out.println();
        }

    }

    private static void soundBird(Bird bird) {
        System.out.println("bird sound test start");
        bird.sound();
        System.out.println("bird sound test end");
    }

    private static void fly(Bird bird) {
        System.out.println("bird flying test start");

        if (bird instanceof Fly flyBird) {
            flyBird.fly();
        }else {
            System.out.println("이 새는 날지못합니다.");
        }
        System.out.println("bird flying test end");
    }

    private static void swim(Bird bird) {
        System.out.println("bird swim test start");

        if (bird instanceof Swim swimBird) {
            swimBird.swim();
        }else {
            System.out.println("이 새는 수영하지 못합니다.");
        }
        System.out.println("bird swim test end");
    }

}
