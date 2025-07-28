package ch01whylambda.step3startlambda;

import ch01whylambda.Procedure;

public class ProcedureMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure(){
            @Override
            public void run() {
                System.out.println("Welcome Lambda");
            }
        };
        procedure1.run();
// ==============================================================

        // () : 매개변수 부분
        // {} : 본문 (실행문이 하나면 생략가능)
        Procedure procedure2 = () -> System.out.println("Welcome Lambda");
        procedure2.run();

    }
}
