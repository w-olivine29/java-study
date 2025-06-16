package ch19inheritance.after.completion.ex1.guitar;

public class AcousticGuitar extends Guitar {


    public AcousticGuitar(String brandName) {
        super(brandName);
    }


    public void play() {
        System.out.println("연주할 기타: 어쿠스틱 기타");
        super.play();
    }
}
