package ch19inheritance.example.ex1;

import java.util.Arrays;

public class Book extends Item {

    private String[] author;
    private String isbn;


    public Book(String itemName, int price, String[] author, String isbn) {
        super(itemName, price);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public void printInfo() {
        System.out.println("\n분류: " + "도서");
        super.printInfo();

        System.out.printf("저자: %s, isbn: %s\n", Arrays.toString(author), isbn);
    }
}
