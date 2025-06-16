package ch21lang.section2string.section5mutable.sub1stringbuilder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {

        //가변객체여서 반환값을 받지 않아도 된다.
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        sb.append("*");
        sb.append("*");
        sb.append("*");
        sb.append("*");
        sb.append("*");
        System.out.println("sb = " + sb);

        sb.insert(3, "Java");
        System.out.println("insert(3, \"Java\")  -> " + sb); //***Java***

        sb.delete(0, 3); //0,1,2 지우기
        System.out.println("delete(0, 3) -> " + sb); //Java***

        sb.reverse();
        System.out.println("sb.reverse() -> " + sb); //***avaJ

        String string = sb.toString();
        System.out.println("string = " + string);
    }
}
