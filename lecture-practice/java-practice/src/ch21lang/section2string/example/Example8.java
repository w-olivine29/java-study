package ch21lang.section2string.example;

// 나열된 문자들을 분리하고, 분리한 문자들을 하나로 합쳐보기
// 분리했던 문자를 다른 구획문자를 넣어 하나로 합쳐보기
public class Example8 {
    public static void main(String[] args) {
        String str = "java,kotlin,python,swift,go";

        String[] splitedStrs = str.split(",");

        StringBuilder sb = new StringBuilder();
        for (String string : splitedStrs) {
            sb.append(string);
        }
        System.out.println("" + sb);


        String result = String.join("&", splitedStrs);
        System.out.println("result = " + result);
    }


}
