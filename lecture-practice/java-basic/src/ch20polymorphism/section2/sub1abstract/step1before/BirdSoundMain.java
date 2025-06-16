package ch20polymorphism.section2.sub1abstract.step1before;

public class BirdSoundMain {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Crow crow = new Crow();
        Parrot parrot = new Parrot();

        // 각 객체의 sound()를 매번 직접 호출해야함 (번거로움 + 중복코드)
        // 타입상이 -> 메서드로 중복을 제거불가, 반복문 사용을 위한 배열생성 불가
        System.out.println("새가 지저귄다");
        sparrow.sound();

        System.out.println("새가 지저귄다");
        crow.sound();

        System.out.println("새가 지저귄다");
        parrot.sound();
    }
}
