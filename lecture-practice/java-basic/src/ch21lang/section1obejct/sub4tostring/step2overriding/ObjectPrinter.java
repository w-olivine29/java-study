package ch21lang.section1obejct.sub4tostring.step2overriding;

abstract public class ObjectPrinter {
    public static void print(Object obj) {
        System.out.println("객체정보 출력: " + obj.toString());
    }
}
