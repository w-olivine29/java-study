package ch24nestedclasses.section2inner.sub3variable;

// 바깥 클래스 인스턴스 변수 & 내부 클래스 인스턴스 변수이름 동일할 경우
public class ShadowingMain {

    public int value = 1; // 외부 필드

    class Inner {
        public int value = 2; //내부 필드


        // shadowing: 동일한 이름의 다른변수에 의해 가려지는 것
        void go() {
            int value = 3; //지역변수
            System.out.println("value = " + value);   //지역변수
            System.out.println("this.value = " + this.value); //내부 필드

            // 자신의 참조값을 포함하고 있는 ShadowingMain 인스턴스의 value
            System.out.println("ShadowMain.value = " + ShadowingMain.this.value); //외부 필드
        }
    }

    public static void main(String[] args) {
        ShadowingMain.Inner inner = new ShadowingMain().new Inner();
        inner.go(); //3
    }
}
