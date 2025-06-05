package ch25exception.section2basic.unchecked;


public class UncheckedThrowMain {
    public static void main(String[] args) {
        Service service = new Service();

        service.catchThrow(); // 처리하지 않았으니, 자동으로 throws
        System.out.println("정상종료"); //도달 불가
    }
}
