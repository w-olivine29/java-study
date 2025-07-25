package ch07annotation.step6javaannotation;

public class DeprecatedClass {
    public void call1() {
        System.out.println("DeprecatedClass.call1");
    }

    // forRemoval = false (기본값): deprecated이지만 호환성을 위해 당분간 유지될 예정
    @Deprecated
    public void call2() {
        System.out.println("DeprecatedClass.call1");
    }


    // forRemoval = true 는 "이 기능은 곧 사라질 예정이니 대안을 찾으라"는 강력한 신호
    @Deprecated(since = "2.4", forRemoval = true)
    public void call3() {
        System.out.println("DeprecatedClass.call1");
    }

}
