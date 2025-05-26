package ch16access.pack1;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public 멤버 접근 (모든 곳에서 접근 가능)
        data.publicField = 100;
        data.publicMethod();

        // default 멤버 접근 (같은 패키지는 접근 가능)
        data.defaultField = 100;
        data.defaultMethod();
        
        // private 멤버 접근 (다른 클래스는 접근 불가)
        //data.privateField = 100; //'privateField' has private access in 'ch16access.pack1.AccessData'
        //data.privateMethod();  //'privateMethod' has private access in 'ch16access.pack1.AccessData'


        // 외부에서 private 필드, 메서드에 접근하려면 접근허용된 메서드를 통해 접근 가능
        data.innerAccess();
    }

}
