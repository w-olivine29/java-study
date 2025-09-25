package ch05javachange.java8.interfacedefaultmethod;

import ch05javachange.java8.interfacedefaultmethod.after.Java8Class;
import ch05javachange.java8.interfacedefaultmethod.after.Java8Class2;
import ch05javachange.java8.interfacedefaultmethod.after.Java8Class3;
import ch05javachange.java8.interfacedefaultmethod.before.Java7Class;

public class InterfaceDefaultMethodExample {
    public static void main(String[] args) {
        Java7Class java7Class = new Java7Class();
        java7Class.printClassName();

        Java8Class java8Class = new Java8Class();
        Java8Class2 java8Class2 = new Java8Class2();
        Java8Class3 java8Class3 = new Java8Class3();

        // default 메서드 호출
        java8Class.printTime();
        java8Class2.printTime();
        java8Class3.printTime();
    }
}
