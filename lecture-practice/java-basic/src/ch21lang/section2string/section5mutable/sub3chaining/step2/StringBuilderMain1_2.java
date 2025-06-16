package ch21lang.section2string.section5mutable.sub3chaining.step2;

public class StringBuilderMain1_2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String result = sb.append("*").append("*").append("*").append("*").append("*")
                .insert(3, "Java")
                .delete(0, 3)
                .reverse().toString();

        System.out.println("result = " + result); //***avaJ
    }
}
