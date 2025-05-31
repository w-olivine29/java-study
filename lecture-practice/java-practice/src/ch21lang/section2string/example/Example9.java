package ch21lang.section2string.example;

//문자 뒤집기
public class Example9 {
    public static void main(String[] args) {

        String str = "complementation";

        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());;
        
    }
}
