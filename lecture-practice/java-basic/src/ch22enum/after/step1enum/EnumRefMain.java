package ch22enum.after.step1enum;

public class EnumRefMain {
    public static void main(String[] args) {

        System.out.println("class BASIC" + Grade.BASIC.getClass());
        System.out.println("class GOLD" + Grade.GOLD.getClass());
        System.out.println("class DIAMOND" + Grade.DIAMOND.getClass());

        System.out.println("ref BASIC: " + Grade.BASIC + "\n"); // ref BASIC: BASIC
        //enum 은 toString이 재정의 돼있어서 직접 확인불가

        // enum에 정의돼있는 상수들이 서로 다른 참조값임을 볼 수 있다.
        System.out.println("ref BASIC: " + refValue(Grade.BASIC));
        System.out.println("ref GOLD: " + refValue(Grade.GOLD));
        System.out.println("ref DIAMOND: " + refValue(Grade.DIAMOND));


    }

    private static String refValue(Object o) {
        return Integer.toHexString(System.identityHashCode(o));
    }

}

