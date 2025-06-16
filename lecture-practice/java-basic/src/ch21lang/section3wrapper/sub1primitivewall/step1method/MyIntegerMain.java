package ch21lang.section3wrapper.sub1primitivewall.step1method;

// 기본형의 한계1
public class MyIntegerMain {
    public static void main(String[] args) {

        MyInteger myInteger = new MyInteger(10);
        System.out.println("myInteger.compareTo(30) -> " + myInteger.compareTo(30)); //-1
        System.out.println("myInteger.compareTo(3) -> " + myInteger.compareTo(3)); //1
        System.out.println("myInteger.compareTo(10) -> " + myInteger.compareTo(10)); //0
    }

}
