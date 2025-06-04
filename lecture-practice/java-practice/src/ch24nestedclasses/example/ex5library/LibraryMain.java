package ch24nestedclasses.example.ex5library;

/* 도서 관리 시스템
* - Library
*   - 여러 권의 도서 정보 관리
*   - 각 도서(Book)는 title, author 데이터를 지님
*   - 기능 구현
*     - 도서 추가
*     - 모든 도서의 정보 출력
*   - Book 객체 배열을 통해 도서목록 관리
*
* - Book 은 Library 내부에서만 사용
* */
public class LibraryMain {

    public static void main(String[] args) {
        Library library = new Library(3);
        library.addBook("This is cs", "kmc");
        library.addBook("Everyone's Network", "mk");
        library.addBook("Effective Java", "jb");
        library.addBook("Everyone's Git&Github", "kmc");
        library.showBooks(); // 도서관의 모든 도서 정보 출력
    }
}
