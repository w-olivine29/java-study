package ch21lang.section1obejct.sub1start;


//Object <- Parent <- Child
public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        // toString(): Object 클래스의 메서드
        String string = child.toString(); //  Child(없음) -> Parent(없음) -> Object(있음)

        // 객체에 대한 정보제공 (패키지@참조값)
        System.out.println("string = " + string); //ch21lang.section1obejct.sub1start.Child@4e50df2e


    }
}
