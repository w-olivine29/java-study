package ch04condition;

public class Condition03Ternary {
    public static void main(String[] args) {
        int age = 30;
        String status;

        if (age >= 19) {
            status = "성인";
        } else {
            status = "미성년자";
        }

        status = (age >= 19) ? "성인" : "미성년자";


        // 중첩도 가능은 함
        status = (age >= 19) ? "성인" :
                 (age > 14) ? "미성년자" :
                 (age > 13) ? "촉법소년" : "초등학생";


        // (age >= 19) ?  System.out.println("") : System.out.println(""); // 삼항연산자는 값을 반환할때 사용
    }
}
