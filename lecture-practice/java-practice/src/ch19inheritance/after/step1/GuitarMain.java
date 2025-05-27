package ch19inheritance.after.step1;

public class GuitarMain {
    public static void main(String[] args) {

        // 모두 부모클래스인 Guitar 에 정의된 기능들이다.
        System.out.println("=== AcousticGuitar ===");
        AcousticGuitar acousticGuitar = new AcousticGuitar();
        acousticGuitar.tune();
        acousticGuitar.play();

        System.out.println("=== ElectricGuitar ===");
        ElectricGuitar electricGuitar = new ElectricGuitar();
        electricGuitar.tune();
        electricGuitar.play();
    }
}
