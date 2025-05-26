package ch16access.example.ex2;

public class Item {

    // 생성자를 통해서만 값을 부여할 수 있게 한다.
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
