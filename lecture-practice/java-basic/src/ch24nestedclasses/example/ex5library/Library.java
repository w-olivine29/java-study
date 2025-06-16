package ch24nestedclasses.example.ex5library;

public class Library {

    private Book[] books;
    private int bookCount; // 0 자동 초기화

    public Library(int capacity) {
        this.books = new Book[capacity];
    }

    public void addBook(String title, String author) {
        if (bookCount >= books.length) {
            System.out.println("더이상 책을 보관할 수 없습니다.");
            return;
        }

        books[bookCount++] = new Book(title, author); //도서를 넣고나서 카운트 증가
    }

    public void showBooks() {
        System.out.println("==== 보관된 책 목록 ====");
        for (Book book : books) {
            System.out.printf("도서 제목: %s, 저자: %s\n",
                    book.title, book.author); // 자신의 중첩클래스는 private 이어도 접근가능
        }
    }


    /* static 중첩 클래스 설계 이유
    - Library와 밀접한 관련은 있으나, 독립적인 데이터 객체
    - Book은 Library에 접근 X (종속 될 필요없음)
    */
    private static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // 필드들이 private 이어도 외부 클래스에서 접근하기 때문에 별도의 getter 제공 필요 X
//        public String getTitle() {
//            return title;
//        }
//
//        public String getAuthor() {
//            return author;
//        }
    }
}
