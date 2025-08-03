package ch05anonymouslambda.sub1this;

public class OuterMain {

    private String message = "외부 클래스";

    public void execute() {

        // 1. 익명클래스 예시
        Runnable anonymous = new Runnable() {

            private String message = "익명 클래스";

            @Override
            public void run() {
                // 익명 클래스에서의 this는 익명 클래스 인스턴스를 가리킴
                System.out.println("[익명 클래스] this: " + this);
                System.out.println("[익명 클래스] this.class: " + this.getClass());
                System.out.println("[익명 클래스] this.message: " + this.message);
            }
        };

        System.out.println("[외부 클래스]" + this.getClass());
        System.out.println("===========================================================================");
        anonymous.run();
        System.out.println("===========================================================================");

        // 2.람다 예시
        Runnable lambda = () -> {
            // 람다에서의 this는 람다가 선언된 클래스의 인스턴스(즉, 외부 클래스) 가리킴
            System.out.println("[람다] this:" + this);
            System.out.println("[람다] this.class:" + this.getClass());
            System.out.println("[람다] this.message:" + this.message);
        };
        lambda.run();
    }

    public static void main(String[] args) {
        OuterMain outerMain = new OuterMain();
        outerMain.execute();
//        [외부 클래스]class ch05anonymouslambda.sub1this.OuterMain

//        [익명 클래스] this: ch05anonymouslambda.sub1this.OuterMain$1@1d81eb93
//        [익명 클래스] this.class: class ch05anonymouslambda.sub1this.OuterMain$1
//        [익명 클래스] this.message: 익명 클래스


//        [람다] this:ch05anonymouslambda.sub1this.OuterMain@34a245ab
//        [람다] this.class:class ch05anonymouslambda.sub1this.OuterMain
//        [람다] this.message:외부 클래스

    }

}
