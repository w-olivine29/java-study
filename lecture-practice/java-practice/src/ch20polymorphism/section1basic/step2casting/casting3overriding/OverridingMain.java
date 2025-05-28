package ch20polymorphism.section1basic.step2casting.casting3overriding;

public class OverridingMain {
    public static void main(String[] args) {

        // 자식 변수 -> 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        System.out.println("child.value = " + child.value); //child
        child.method(); //child


        // 부모 변수 -> 부모 인스턴스 참조
        System.out.println("\nParent -> Child");
        Parent parent1 = new Parent();
        System.out.println("parent1.value = " + parent1.value); //parent
        parent1.method(); //parent


        // 부모 변수 -> 자식 인스턴스 참조 (다형적 참조)
        System.out.println("\nParent -> Child");
        Parent parent2 = new Child();
        System.out.println("parent2.value = " + parent2.value); //parent (변수는 오버라이딩 x)
        parent2.method(); //child (메서드는 오버라이딩 o)
        
        // 오버라이딩 된 메서드는 절대적 우선권을 가짐
    }
}
