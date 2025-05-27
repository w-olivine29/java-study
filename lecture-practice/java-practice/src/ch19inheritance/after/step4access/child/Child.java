package ch19inheritance.after.step4access.child;

import ch19inheritance.after.step4access.parent.Parent;

public class Child extends Parent {

    /*
     * Child 타입으로 인스턴스를 생성 시, 내부에 Parent 클래스도 함께 포함해서 생성되지만, "공간은 구분"
     *
     * 내부에 Child, Parent 모두 존재하지만, "공간은 구분" 돼있기때문에
     * Parent 입장에서는 외부에서 접근한 것과 같음
     *
     * -> default(동일 패키지는 가능) , private 접근 불가
     * */
    public void callParent() {
        publicValue = 1;
        protectedValue = 1; // 동일 패키지 or 상속관계 ok
//        defaultValue = 1; //Cannot be accessed from outside package
//        privateValue = 1; //has private access in

        publicMethod();
        protectedMethod();
//        defaultMethod(); //Cannot be accessed from outside packag
//        privateMethod(); //has private access in


        printParent();
    }
}
