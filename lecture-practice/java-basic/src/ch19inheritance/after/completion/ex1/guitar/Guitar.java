package ch19inheritance.after.completion.ex1.guitar;

public class Guitar {

    String brand;
    boolean isTuned;


    public Guitar(String brandName) {
        brand = brandName;
    }

    
    public void play() {
        checkStatus(); // ElectricGuitar 인스턴스가 play() 호출 -> 오버라이딩 된 checkStatus() 호출
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
