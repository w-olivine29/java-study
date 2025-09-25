package ch05javachange.java8.interfacedefaultmethod.before;

public class Java7Class2 implements Java7Interface {
    @Override
    public void printClassName() {
        System.out.println(getClass().getSimpleName());
    }
}
