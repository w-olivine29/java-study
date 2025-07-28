package ch01whylambda.step2behaviorparameterization;

import ch01whylambda.Procedure;

import java.util.Random;

public class Ex1RefMain {

    public static void hello(Procedure procedure){
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns\n");
    };
    public static void main(String[] args) {

        hello(new Procedure(){
            @Override
            public void run(){
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
            }
        });

        hello(new Procedure(){
            @Override
            public void run(){
                for (int i = 1; i <= 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        });
    }
}

/* 동작 매개변수화
코드 조각을 메서드 안에 두는 것이 아닌, 매개변수를 통해서 외부에서 전달받음으로써,
메서드의 동작을 달리하고, 재사용성으을 높이는 방법
동작 매개변수화, 동작 파라미터화, 행동 매개변수화(파라미터화) 행위 파라미터화 등으로 불림
*/