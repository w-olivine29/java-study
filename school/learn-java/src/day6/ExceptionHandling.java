package day6;

public class ExceptionHandling {
    public static void main(String[] args) {
        
        // 1. try-catch
        try {
            int number = Integer.parseInt("abc");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("숫자 변환 불가");
        }

        // 2. 다중 try-catch
        try {
            String str = null;
            System.out.println(str.length());
            int number = Integer.parseInt("abc");
        } catch (NullPointerException e) {
            System.out.println("null");
        } catch (NumberFormatException e) {
            System.out.println("숫자 변환 불가");
        } catch (Exception e) {
            System.out.println("그 외 예외 발생");
        }

        // 3. try-catch-finally
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 오류 발생");
        } finally {
            System.out.println("try- catch 이후에 무조건 실행되는 코드");
        }

        try {
            divide(10, 0);
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }

    }

    // 예외를 호출한 쪽으로 던지기 (책임 전가)
    public static void divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("0으로 나눌 수 없습니다.");
        }
        System.out.println(a / b);
    }
}
