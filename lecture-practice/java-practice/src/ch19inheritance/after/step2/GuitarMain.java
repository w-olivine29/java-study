package ch19inheritance.after.step2;

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
        electricGuitar.connectToAmp(); // ElectricGuitar에 새로 추가된 기능
        electricGuitar.play();
        electricGuitar.disconnectFromAmp(); // ElectricGuitar에 새로 추가된 기능
    }
}
