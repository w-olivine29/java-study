package ch02lambda.step1define;

import ch01whylambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("welcome Lambda");
            }
        };
        System.out.println("procedure.getClass() = " + procedure1.getClass()); //class ch02lambda.step1define.InstanceMain$1
        System.out.println("procedure.instance = " + procedure1); //ch02lambda.step1define.InstanceMain$1@7291c18f

//===============================================================================

        // new 연산자와 생성자를 사용하지 않으나, 람다도 익명클래스처럼 인스턴스 생성
        Procedure procedure2 = () -> System.out.println("welcome Lambda");

        System.out.println("procedure.getClass() = " + procedure2.getClass()); //class ch02lambda.step1define.InstanceMain$$Lambda/0x0000014e01003988
        System.out.println("procedure.instance = " + procedure2); //ch02lambda.step1define.InstanceMain$$Lambda/0x0000014e01003988@7cc355be
    }
}

/*
 람다 사용 시 익명클래스 사용의 보일러플레이트 코드를 크게 줄이고,
 간결한 코드로 생산성과 가독성을 높일 수 있음
 (그러나 람다가 익명 클래스를 완전히 대체할 수 있는 것은 아님)
 
 현재는 익명클래스 구현을 간결하게 해주는 역할 정도로 이해하기
 (람다와 익명 클래스 차이는 챕터5 람다 vs 익명클래스 에서 설명)
*/