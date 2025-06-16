package ch19inheritance.example.ex1;

import java.util.Arrays;

public class Movie extends Item {

    private String director;
    private String[] actors;

    public Movie(String itemName, int price, String director, String[] actors) {
        super(itemName, price);
        this.director = director;
        this.actors = actors;
    }

    @Override
    public void printInfo() {
        System.out.println("\n분류: " + "영화");
        super.printInfo(); // 이름, 가격

        System.out.printf("감독: %s, 주연배우: %s\n", director, Arrays.toString(actors));
    }
}
