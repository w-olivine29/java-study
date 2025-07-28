package ch02lambda.step2functionalinterface;

public class SamMain {

    public static void main(String[] args) {
        // SAM 에는 람다 할당 가능
        SamInterface samInterface = () -> System.out.println("sam");
        samInterface.run();

        // Multiple non-overriding abstract methods found in NotSamInterface
        //NotSamInterface notSamInterface =  () -> System.out.println("sam");
    }
}
