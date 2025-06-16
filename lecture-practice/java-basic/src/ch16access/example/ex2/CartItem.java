package ch16access.example.ex2;

public class CartItem {

    private Item item;
    private int quantity;


    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getAmount() {
        return item.getPrice() * quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }


//    public void increaseQuantity(int quantity) {
//
//        if (!isValidQuantity(quantity)) {
//            System.out.println("잘못된 수량입니다.");
//            return;
//        }
//        this.quantity += quantity;
//    }
//
//    public void decreaseQuantity(int quantity) {
//        if (!isValidQuantity(quantity) || this.quantity <= quantity) {
//            System.out.println("잘못된 수량입니다.");
//            return;
//        }
//        this.quantity -= quantity;
//

//    }
//    private boolean isValidQuantity(int quantity) {
//        return quantity > 0;
//    }
//
//


}
