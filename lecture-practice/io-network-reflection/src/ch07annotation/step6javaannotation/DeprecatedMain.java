package ch07annotation.step6javaannotation;

public class DeprecatedMain {
    public static void main(String[] args) {
        DeprecatedClass deprecatedClass = new DeprecatedClass();
        deprecatedClass.call1();
        deprecatedClass.call2(); // IDE 경고
        deprecatedClass.call3(); // IDE 경고 (심각) - IDE에서 빨간줄이 뜨지만 컴파일 오류는 아님
    }
}
