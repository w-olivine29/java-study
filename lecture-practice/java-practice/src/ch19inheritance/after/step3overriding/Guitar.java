package ch19inheritance.after.step3overriding;

public class Guitar {

    boolean isTuned;

    public void play() {
        checkStatus();
        System.out.println("기타를 연주합니다.");
    }


    public void tune() {
        isTuned = true;
        System.out.println("튜닝 완료");
    }

    public void checkStatus() {
        if (!isTuned) {
            System.out.println("튜닝 전 상태");
        }
    }
}
