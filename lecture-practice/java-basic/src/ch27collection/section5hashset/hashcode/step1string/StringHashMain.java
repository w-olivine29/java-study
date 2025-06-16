package ch27collection.section5hashset.hashcode.step1string;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        //char
        char charA = 'A';
        char charB = 'B';
        System.out.println("charA = " + (int) charA); //65
        System.out.println("charB = " + (int) charB); //66
        System.out.println("charB = " + (charA + charB)); //131

        System.out.println("hashCode(\"A\") => " + hashCode(String.valueOf(charA))); //65
        System.out.println("hashCode(\"B\") => " + hashCode(String.valueOf(charB))); //66
        System.out.println("hashCode(\"AB\") => " + hashCode("AB")); //131


        //hashIndex
        System.out.println("hashIndex(hashCode(\"A\")) = " + hashIndex(hashCode("A")));
        System.out.println("hashIndex(hashCode(\"B\")) = " + hashIndex(hashCode("B")));
        System.out.println("hashIndex(hashCode(\"AB\")) = " + hashIndex(hashCode("AB")));


    }

    private static int hashCode(String str) {
        char[] charArr = str.toCharArray();

        int sum = 0;
        for (char c : charArr) {
            sum += c;
        }

        return sum;
    }

    private static int hashIndex(int value) {
        return value % CAPACITY;
    }



        /*
            컴퓨터는 문자를 직접 이해하지 못함
            -> 각 문자에 고유한 숫자를 할당해서 인식

            - 해시함수:
                고정된 길이(저장공간 크기)의 해시값 출력하는 함수
                다른 데이터를 입력해도 같은 해시코드 출력 가능 -> 해시 충돌

                ex) "Ab" => 65 + 98 = 163
                    "Ba" => 66 + 97 = 163

            - 해시코드:
                데이터를 대표하는 값 (해시함수를 통해 만들어짐)

            - 해시인덱스:
                해시코드를 이용해서 만듬
                데이터의 저장 위치 결정


            next step)
                객체의 경우?
                자바의 hashCode() 메서드
    */
}
