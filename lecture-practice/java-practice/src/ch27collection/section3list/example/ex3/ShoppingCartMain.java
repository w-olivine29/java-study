package ch27collection.section3list.example.ex3;


/* 문제4
해당 코드가 작동하도록 ShoppingCart 클래스를 완성하라.
ShoppingCart는 내부에 리스트를 사용
*/
public class ShoppingCartMain {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.displayItems();
    }
}