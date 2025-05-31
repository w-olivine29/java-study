package ch21lang.section2string.section2comparison;

public class StringEqualsMain1 {
    public static void main(String[] args) {

        //new String() -> new 연산자로 서로 다른 객체로 생성 (참조값이 다름)
        String str1 = new String("java");
        String str2 = new String("java");

        System.out.println("new String() [== 비교] -> " + (str1 == str2)); //false (참조값 비교로 실패)

        // String의 equals()는 내부 문자열값을 비교하도록 오버라이딩 돼있음
        System.out.println("new String() [equals() 비교] -> " + (str1.equals(str2))); //true


        // 문자열 리터럴 생성
        String str3 = "java";
        String str4 = "java";
        System.out.println("리터럴 [== 비교] -> " + (str3 == str4)); //true
        System.out.println("리터럴 [equals() 비교] -> " + (str3.equals(str4))); //true

        /* 문자열 리터럴
         * 1. 실행시점에 문자열 리터럴 있음 -> "문자열풀"에 인스턴스 생성
         * 2. 후에 또 다른 문자열 리터럴 있음 -> "문자열풀"에서 같은 문자열을 가진 인스턴스 찾음
         *    -> 있다면 해당 참조값 반환
         *    -> 없다면 인스턴스 생성
         *
         * -> 메모리 효율성 & 성능 최적화 가능
         * */

    }
}
