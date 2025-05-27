package ch19inheritance.after.step3overriding;

public class GuitarMain {
    public static void main(String[] args) {

        System.out.println("=== AcousticGuitar ===");
        AcousticGuitar acousticGuitar = new AcousticGuitar();
        acousticGuitar.play();
        acousticGuitar.tune();
        acousticGuitar.play();


        System.out.println("=== ElectricGuitar ===");
        ElectricGuitar electricGuitar = new ElectricGuitar();
        electricGuitar.tune();

        // play() 내부에서는 ElectricGuitar에서 재정의한 checkStatus()를 호출하는 상태
        electricGuitar.play();

        electricGuitar.connectToAmp();
        electricGuitar.play();
    }
}
