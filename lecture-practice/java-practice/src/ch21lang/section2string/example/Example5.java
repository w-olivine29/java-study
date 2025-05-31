package ch21lang.section2string.example;

// 문자열에서 key로 주어지는 문자를 찾고, 찾은 문자의 수 출력
public class Example5 {
    public static void main(String[] args) {
        String str = "papagopapagopapagopapagopapagopapago";
        String key = "papago";
        //            012345678901234567890123456789012345
        //            0         1         2         3

        int count = 0;
        int idx = 0;
        while (idx < str.length()) {
            int keyIndex = str.indexOf(key, idx);
            if (keyIndex == -1) {
                break;
            }
            idx = keyIndex + key.length();
            count++;
        }
        System.out.println(key + "의 개수 " + count);
    }
}
