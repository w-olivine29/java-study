package ch21lang.section2string.section2comparison;

// 리터럴이어도 equals를 사용해야하는 이유
public class StringEqualsMain2 {
    public static void main(String[] args) {
        
        String str1 = new String("java");
        String str2 = new String("java");

        System.out.println("메서드호출 비교1 -> " + isSame(str1, str2));

        String str3 = "java";
        String str4 = "java";
        System.out.println("메서드호출 비교2 -> " + isSame(str3, str4)); //true


    }

    // new String() 생성 인스턴스인지, 리터럴이 들어올지 모르기때문에 String은 무조건 equals() 비교로 통일한다.
    private static boolean isSame(String x, String y) {
        return x.equals(y);
    }
}
