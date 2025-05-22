package ch05loop;

public class Loop02DoWhile {
    public static void main(String[] args) {
        
        // do-while: 최초 한번은 코드 블럭을 꼭 실행하는 경우에 사용
        int cnt = 10;

        do {
            System.out.printf("cnt: %d", cnt++);
        } while (cnt < 3);

    }
}
