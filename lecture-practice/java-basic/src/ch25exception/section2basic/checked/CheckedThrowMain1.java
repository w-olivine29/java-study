package ch25exception.section2basic.checked;

public class CheckedThrowMain1 {
    public static void main(String[] args) throws MyCheckedException {
        Service service = new Service();
        service.catchThrow1();

        System.out.println("정상 종료"); //도달 불가
    }
}
