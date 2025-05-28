package ch20polymorphism.section2.sub1abstract.step2poly;

/* 해당 코드의 문제점)
 * 자식 클래스들이 아닌, Animal 인스턴스를 넣을 수도 있는 가능성 (Animal 클래스는 다형성을 위해 만든 것일뿐)
 * -> 객체생성방지 필요
 * 자식 클래스에서 메서드 오버라이딩을 하지 않을 가능성
 *
 * 추상클래스 & 추상메서드를 통해 해결가능
 * */
public class BirdSoundMain {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird crow = new Crow();
        Bird parrot = new Parrot();

        // 다형적 참조로 하나의 타입으로 담을 수 있게 되었다.
        Bird[] birds = {new Sparrow(), new Crow(), new Parrot()};

        // Bird인 상태지만, 오버라이딩된 메서드 호출
        for (Bird bird : birds) {
            soundBird(bird);
            System.out.println();
        }

    }

    private static void soundBird(Bird bird) {
        System.out.println("bird sound test start");
        bird.sound();
        System.out.println("bird sound test end");
    }

}
