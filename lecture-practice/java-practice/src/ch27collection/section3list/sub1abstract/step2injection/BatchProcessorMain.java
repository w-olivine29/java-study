package ch27collection.section3list.sub1abstract.step2injection;

import ch27collection.section3list.sub2performance.mylist.MyArrayList;
import ch27collection.section3list.sub2performance.mylist.MyLinkedList;

public class BatchProcessorMain {
    public static void main(String[] args) {

        // 의존관계 주입 (생성자로 원하는 구현체를 전달)
        BatchProcessor_DI batchProcessorDI1 = new BatchProcessor_DI(new MyArrayList<>());
        BatchProcessor_DI batchProcessorDI2 = new BatchProcessor_DI(new MyLinkedList<>());


        // 성능비교 (데이터 수가 증가할수록 성능차이 up)
        System.out.println("== MyArrayList 주입 =="); // O(n * n)
        batchProcessorDI1.logic(50_000); // 1454ms
        //batchProcessorDI1.logic(100_000); // 13124ms
        //batchProcessorDI1.logic(500_000); // 먹통

        System.out.println("\n== MyLinkedList 주입 =="); //O(1)
        batchProcessorDI2.logic(50_000);  // 2ms
        batchProcessorDI2.logic(100_000); // 2ms
        batchProcessorDI2.logic(500_000); // 142ms
    }

}