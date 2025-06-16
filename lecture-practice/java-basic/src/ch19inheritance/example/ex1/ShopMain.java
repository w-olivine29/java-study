package ch19inheritance.example.ex1;

/* 쇼핑몰의 판매 상품 만들기
코드 중복이 없도록 한다.
부모 클래스는 Item
공통 속성: name, price
각 아이템의 필드값들을 출력한다.
* */
public class ShopMain {
    public static void main(String[] args) {

        Book book = new Book("this is cs", 36000, new String[]{"kmc"}, "979-11-6921-0254-0 93000");

        Album album = new Album("albumAlbum", 0, new String[]{"human1, human2"});

        Movie movie = new Movie("Pearl Harbor", 12000, "Michael Bay",
                new String[]{"Ben Affleck", "Josh Hartnett", "Kate Beckinsale"});

        book.printInfo();
        album.printInfo();
        movie.printInfo();


/*        분류: 도서
        이름: this is cs, 가격: 36000
        저자: [kmc], isbn: 979-11-6921-0254-0 93000

        분류: 앨범
        이름: albumAlbum, 가격: 0
        아티스트: [human1, human2]

        분류: 영화
        이름: Pearl Harbor, 가격: 12000
        감독: Michael Bay, 주연배우: [Ben Affleck, Josh Hartnett, Kate Beckinsale]*/
    }
}
