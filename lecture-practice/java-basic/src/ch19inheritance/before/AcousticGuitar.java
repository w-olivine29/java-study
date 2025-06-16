package ch19inheritance.before;

public class AcousticGuitar {

    private boolean isTuned;

    public void play() {
        if (!isTuned) {
            System.out.println("튜닝 전 상태");
        }
        System.out.println("기타를 연주합니다.");
    }

    public void tune() {
        isTuned = true;
        System.out.println("튜닝 완료");
    }
}
