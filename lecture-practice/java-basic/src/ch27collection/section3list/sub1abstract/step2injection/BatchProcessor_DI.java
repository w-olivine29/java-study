package ch27collection.section3list.sub1abstract.step2injection;

import ch27collection.section3list.sub2performance.mylist.MyList;

public class BatchProcessor_DI {


    private final MyList<Integer> list;

    // list 의 구현체는 런타임 시점에 생성자를 통해 결정
    // 의존관계가 내부가 아닌 외부에서 결정한 뒤 주입되는 모양새 => "의존관계 주입 , Dependency Injection" 이라 표현
    public BatchProcessor_DI(MyList<Integer> list) {   // 생성자 의존관계주입
        this.list = list;
    }


    public void logic(int size) {   // 복잡한 로직이라 가정 (list 앞 부분에 데이터 추가 반복)
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) { // 반복문 전체 도는데 O(n)
            list.add(0, i); // 데이터 하나 추가할때마다 전체 데이터 이동때문에 O(n)
        }
        long endTime = System.currentTimeMillis();
        System.out.println("size: " + size + " ,time: " + (endTime - startTime) + "ms");
    }


    /*
    해당 클래스는 List 인터페이스에 의존하고, 구현체(ArrayList, LinkedList)에는 직접 의존하지 않음
    구현체는 런타임 시점에 생성자를 통해 주입 (생성자 의존관계 주입)

    실제 구현체는 생성자 주입을 통해 런타임 시점에 결정
        → 즉, 구현체 교체 시 클래스 내부 코드 변경이 필요 없음

        ex)  
            List의 구현체인 ArrayList를 주입
              -> logic 메서드 내의 로직을 실행하기에 성능이 좋지못함  -> 생성자에 전달하는 구현체를 LinkedList 로만 변경하면 됨


    클래스 내에서는 추상화해놓고, 어떤 구현체를 선택할지는 생성자를 통해 결정 (의존관계를 클래스 정의시점이 아닌 런타임시점으로 미루기)
    이는 의존성 역전 원칙(DIP)과 개방-폐쇄 원칙(OCP)을 따른 설계 방식
    */
}
