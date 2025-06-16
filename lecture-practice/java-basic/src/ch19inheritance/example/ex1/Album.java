package ch19inheritance.example.ex1;

import java.util.Arrays;

public class Album extends Item {

    String[] artist;

    public Album(String itemName, int price, String[] artist) {
        super(itemName, price);
        this.artist = artist;
    }

    @Override
    public void printInfo() {
        System.out.println("\n분류: " + "앨범");
        super.printInfo();

        System.out.printf("아티스트: %s\n", Arrays.toString(artist));
    }
}
