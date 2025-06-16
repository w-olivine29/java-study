package ch16access.pack1;

// 접근제어자 관점에서 생성자는 메서드와 같기때문에 생략
// protected는 상속챕터에서
public class AccessData {

    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod() {
        System.out.println("AccessData.publicMethod 호출: " + publicField);
    }

    void defaultMethod() {
        System.out.println("AccessData.defaultMethod 호출" + defaultField);
    }

    private void privateMethod() {
        System.out.println("AccessData.privateMethod 호출:" + privateField);
    }


    // 외부에서 private 필드, 메서드에 접근하려면 접근허용된 메서드를 통해 접근 가능
    public void innerAccess() {
        System.out.println("AccessData.innerAccess");
        publicField = 100;
        defaultField = 100;
        privateField = 100;

        publicMethod();
        defaultMethod();
        privateMethod();
    }
}
