package ch19inheritance.after.step2;

// 새로운 필드, 메서드를 추가
public class ElectricGuitar extends Guitar {

    private boolean isConnectedToAmp;

    public void connectToAmp() {
        isConnectedToAmp = true;
        System.out.println("앰프 연결완료");
    }

    public void disconnectFromAmp() {
        isConnectedToAmp = false;
        System.out.println("앰프 연결 해제");
    }
}
