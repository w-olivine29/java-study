package ch17memory.example.ex1;

public class Car {

    private String name;
    private static int totalCount;

    public Car(String name) {
        this.name = name;
        totalCount++;

        System.out.println("차량 판매: " + name);
    }

    public static int getTotalCount() {
        return totalCount;
    }
}
