package ch25exception.section2basic.checked;

public class CheckedThrowMain2 {
    public static void main(String[] args) throws MyCheckedException {
        Service service = new Service();
        //service.catchThrow2();

        /* 흐름
        * Client call() -> throws MyCheckedException
        * Service catchThrow2() throws Exception (다형성 적용)
        * Main throws MyCheckedException (불가)
        *      -> 자식은 부모를 못 담는다
        * */

        System.out.println("정상 종료"); //도달 불가
    }
}
