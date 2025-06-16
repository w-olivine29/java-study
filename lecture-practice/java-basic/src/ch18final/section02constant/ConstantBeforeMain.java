package ch18final.section02constant;

/*
프로그램 상 의미있는 값을 상수로 사용하지 않았음

Magic Number)
"의미 없이" 코드에 직접 박혀 있는 "숫자 상수"

->  가독성 저하, 유지보수 어려움, 버그, 재사용불가 등 문제야기
 */
public class ConstantBeforeMain {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + 100); //Magic Number
        int currentCount = 99;

        joinProcess(++currentCount); // 참고) 후위연산자의 경우 1증가하기전의 값이 복사되어 인수로 넘겨짐
        joinProcess(++currentCount);
        joinProcess(++currentCount);
    }

    static void joinProcess(int currentCount) {
        System.out.println("=============================");
        System.out.println("현재 참여자 수: " + currentCount);

        if (currentCount > 100) {  // Magic Number  -> "왜 100이 기준인지", "혹시 바뀔 수 있는 값인지" 의도가 명확하게 드러나지 않음
            System.out.println("=== 대기자 등록 ===");
            System.out.print("대기자 인원: " + (currentCount - 100) + "\n");
        } else {
            System.out.println("&&& 참여 &&&");
        }

    }
}
