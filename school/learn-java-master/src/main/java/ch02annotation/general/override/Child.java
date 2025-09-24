package ch02annotation.general.override;

public class Child extends Parent {

    @Override
    public void printMessage() {
        System.out.println("Child.printMessage");
    }
}
