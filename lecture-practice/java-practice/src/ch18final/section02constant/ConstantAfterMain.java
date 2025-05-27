package ch18final.section02constant;


public class ConstantAfterMain {

    // 정책이 바뀌면, 해당 상수값만 변경하면 된다.
    static final int MAX_USER = 100;

    public static void main(String[] args) {

        System.out.println("프로그램 최대 참여자 수 " + ConstantAfterMain.MAX_USER); //상수로 변경
        int currentCount = 99;

        joinProcess(++currentCount); // 참고) 후위연산자의 경우 1증가하기전의 값이 복사되어 인수로 넘겨짐
        joinProcess(++currentCount);
        joinProcess(++currentCount);
    }

    static void joinProcess(int currentCount) {
        System.out.println("=============================");
        System.out.println("현재 참여자 수: " + currentCount);

        if (currentCount > ConstantAfterMain.MAX_USER) {  //상수로 변경
            System.out.println("=== 대기자 등록 ===");
            System.out.print("대기자 인원: " + (currentCount - ConstantAfterMain.MAX_USER) + "\n");
        } else {
            System.out.println("&&& 참여 &&&");
        }

    }
}
