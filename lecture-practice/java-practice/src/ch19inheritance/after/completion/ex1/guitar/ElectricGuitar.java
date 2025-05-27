package ch19inheritance.after.completion.ex1.guitar;


public class ElectricGuitar extends Guitar {

    private boolean isConnectedToAmp;

    public ElectricGuitar(String brandName) {
        super(brandName);
    }

    @Override
    public void play() {
        System.out.println("연주할 기타: 일렉트로닉 기타");
        super.play();
    }

    @Override
    public void checkStatus() {
        super.checkStatus();
        if (!isConnectedToAmp) {
            System.out.println("앰프 미연결상태");
        }
    }

    public void connectToAmp() {
        isConnectedToAmp = true;
        System.out.println("앰프 연결완료");
    }

    public void disconnectFromAmp() {
        isConnectedToAmp = false;
        System.out.println("앰프 연결 해제");
    }
}
