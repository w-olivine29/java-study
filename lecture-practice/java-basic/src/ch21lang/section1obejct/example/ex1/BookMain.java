package ch21lang.section1obejct.example.ex1;

/* toString(), equals() 구현하기
 * */
public class BookMain {
    public static void main(String[] args) {

        Book book1 = new Book("This is cs", "kmc", "979-11-6921-254-0 93000");
        Book book2 = new Book("This is cs", "kmc", "979-11-6921-254-0 93000");
        Book book3 = new Book("cs note", "jhc", "979-11-6521-952-9 93000");

        System.out.println("=== 책 정보 출력 ============");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("=== 동일성 비교 =============");
        System.out.println("book1 == book2 -> " + (book1 == book2)); //false
        System.out.println("book2 == book3 -> " + (book2 == book3)); //false
        System.out.println("book1 == book3 -> " + (book1 == book3)); //false

        System.out.println("=== 동등성 비교 =============");
        System.out.println("book1.equals(book2) -> " + book1.equals(book2)); //true
        System.out.println("book2.equals(book3) -> " + book1.equals(book3)); //false
        System.out.println("book2.equals(book3) -> " + book2.equals(book3)); //false
    }
}
