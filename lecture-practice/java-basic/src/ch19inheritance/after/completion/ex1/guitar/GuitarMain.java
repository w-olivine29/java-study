package ch19inheritance.after.completion.ex1.guitar;

public class GuitarMain {
    public static void main(String[] args) {

        System.out.println("=== AcousticGuitar ===");
        AcousticGuitar acousticGuitar = new AcousticGuitar("MartinD28");
        acousticGuitar.play();
        acousticGuitar.tune();
        acousticGuitar.play();


        System.out.println("=== ElectricGuitar ===");
        ElectricGuitar electricGuitar = new ElectricGuitar("FenderStratocaster");
        electricGuitar.tune();
        electricGuitar.play();

        electricGuitar.connectToAmp();
        electricGuitar.play();
    }
}
