package ch06reflection.step1class;

import ch06reflection.data.BasicData;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class BasicV2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<BasicData> basicData = BasicData.class;

        System.out.println("basicData.getName() = " + basicData.getName()); //ch06reflection.data.BasicData
        System.out.println("basicData.getSimpleName() = " + basicData.getSimpleName()); //BasicData
        System.out.println("basicData.getPackage() = " + basicData.getPackage()); //package ch06reflection.data

        System.out.println("basicData.getSuperclass() = " + basicData.getSuperclass()); //class java.lang.Object
        System.out.println("basicData.getInterfaces() = " + Arrays.toString(basicData.getInterfaces())); //[]

        System.out.println("basicData.isInterface() = " + basicData.isInterface()); //fasle
        System.out.println("basicData.isEnum() = " + basicData.isEnum()); //false

        // Java에서 모든 접근 제한자들은 비트 플래그로 표현 (public=1, private=2, protected=4, static=8, final=16)
        int modifiers = basicData.getModifiers();
        System.out.println("basicData.getModifiers() = " + modifiers); //1
        System.out.println("isPublic = " + Modifier.isPublic(1)); //true
        System.out.println("Modifier.toString() = " + Modifier.toString(modifiers)); //public
    }
}
