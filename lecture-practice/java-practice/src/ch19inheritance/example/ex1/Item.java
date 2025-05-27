package ch19inheritance.example.ex1;

public class Item {

    private String itemName;
    private int price;

    public Item(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    public void printInfo() {
        System.out.printf("이름: %s, 가격: %d \n", itemName, price);
    }
}
