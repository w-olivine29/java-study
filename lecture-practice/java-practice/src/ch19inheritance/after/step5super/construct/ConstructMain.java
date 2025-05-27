package ch19inheritance.after.step5super.construct;

public class ConstructMain {
    public static void main(String[] args) {
        ClassC classC = new ClassC();
        
        /* [상속관계] C -> B -> A
        *   [생성자 호출 순] C -> B -> A
        *   [초기화 순 (생성자 실행 순)] A -> B -> C
        * */
    }
}
