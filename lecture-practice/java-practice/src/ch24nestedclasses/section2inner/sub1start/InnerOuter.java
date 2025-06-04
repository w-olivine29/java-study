package ch24nestedclasses.section2inner.sub1start;

public class InnerOuter {
    private static int outClassValue = 10;
    private int outInstanceValue = 20;

    class Inner {
        private int innerInstanceValue = 30;

        public void print() {
            
            // 자기 자신에 접근 (가능)
            System.out.println("innerInstanceValue = " + innerInstanceValue);

            // 외부 클래스 인스턴스 멤버 접근 (private도 가능)
            System.out.println("outInstanceValue = " + outInstanceValue);

            // 외부 클래스 클래스 멤버에 접근 가능 (private도 가능)
            System.out.println("outClassValue = " + outClassValue);
        }

    }
}
