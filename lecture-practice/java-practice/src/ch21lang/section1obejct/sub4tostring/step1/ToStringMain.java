package ch21lang.section1obejct.sub4tostring.step1;

public class ToStringMain {
    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();


        /* Object의 toString()
        return getClass().getName() + "@" + Integer.toHexString(hashCode())
        */
        // object 직접 출력
        System.out.println(object); // java.lang.Object@b4c966a

        // toString() 반환값 출력
        System.out.println(string); // java.lang.Object@b4c966a

        // 직접 객체를 출력한것과 , toString 값이 같은 이유)
        // System의 프린트 메서드 내부) Object객체.toString -> String.valueOf 된 값으로 반환


    }
}
