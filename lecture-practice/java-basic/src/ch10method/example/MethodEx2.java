package ch10method.example;

// 반복출력
public class MethodEx2 {
    public static void main(String[] args) {
        String message = "긴급알림";
        int printNum = 5;
        
        printMessage(message, printNum);
    }

    static void printMessage(String message, int printNum) {
        for (int i = 0; i < printNum; i++) {
            System.out.println(message);
        }
    }


}
