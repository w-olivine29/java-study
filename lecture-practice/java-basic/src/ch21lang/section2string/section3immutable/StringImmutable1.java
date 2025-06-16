package ch21lang.section2string.section3immutable;

public class StringImmutable1 {
    public static void main(String[] args) {
        String str = "git";
        str.concat("hub");
        System.out.println("str = " + str); // git
        
        // String은 생성이후엔 내부값을 바꿀 수 없는 불변객체   private final byte[] value;
        // concat 메서드는 내부값을 변경시키는 것이 아닌 새로운 객체를 반환

        String concatStr = str.concat("hub"); // hub 라는 값을 가진 새로운 객체를 반환
        System.out.println("concatStr = " + concatStr);
        
        /* String이 불변객체로 설계된 이유 중 하나는
        * 가변객체일 경우 "문자열 풀"에서의 사이드이펙트 문제 발생이 불가피하기때문
        * (나머지 이유들은 따로 찾아보기)
        * */
    }
}
