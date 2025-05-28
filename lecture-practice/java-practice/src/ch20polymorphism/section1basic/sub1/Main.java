package ch20polymorphism.section1basic.sub1;

public class Main {
    public static void main(String[] args) {

        // 부모 변수 -> 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수 -> 자식 인스턴스 참조
        System.out.println("\nChild -> Child");
        Child child = new Child();
        child.parentMethod(); // Child 접근 ->  해당 메서드 없음 -> Parent에 접근해서 찾고 호출
        child.childMethod(); // Child에 있으니 바로 호출


        // 자식타입 변수 -> 부모 인스턴스 참조 (불가)
        //Child child1 = new Parent();

        /*
         * 부모타입 인스턴스로 생성 시 내부엔 부모클래스의 구성만 있기에 자식타입 변수로 참조불가
         *
         * 자식타입 인스턴스로 생성 시 내부엔 부모, 자식의 멤버가 모두 포함되어 구성
         * 부모타입 구조를 바라볼 수 있음 -> 부모 타입변수로도 참조가능
         *  */


        // 부모타입 변수 -> 자식 인스턴스 참조 (다형적 참조)
        System.out.println("\nParent -> Child");
        Parent poly = new Child();
        poly.parentMethod();
        
        //Child child1 = new Parent();  //cannot be converted to Child
        //poly.childMethod(); //cannot find symbol


        /* 왜 Child 인스턴스임에도 childMethod()를 사용할 수 없는가?
         *   자식 타입의 인스턴스로 생성했어도, 부모타입의 변수에 담았기에
         *   인스턴스 안의 부모에 접근하는 상태
         *
         *   상속관계는 자식 -> 부모로 찾아갈 수 있지만, 부모에서 자식으로 찾아갈 수는 없다.
         *   자식 클래스는 부모클래스에 대한 정보가 있다. (class Child "extends Parent")
         *   but 부모 클래스에는 자식클래스에 대한 정보가 없다.
         * */


    }
}
