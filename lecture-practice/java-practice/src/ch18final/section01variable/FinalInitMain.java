package ch18final.section01variable;

public class FinalInitMain {
    public static void main(String[] args) {
        // final 필드 - 생성자 초기화
        System.out.println("=== 생성자 초기화 ===");
        FinalInit finalInit1 = new FinalInit(1);
        FinalInit finalInit2 = new FinalInit(2);
        FinalInit finalInit3 = new FinalInit(3);

        System.out.println("fieldInit1.constructInitValue = " + finalInit1.constructInitValue);
        System.out.println("fieldInit2.constructInitValue = " + finalInit2.constructInitValue);
        System.out.println("fieldInit3.constructInitValue = " + finalInit3.constructInitValue);

        // final 필드 - 필드 초기화
        System.out.println("=== 필드 초기화 ===");
        System.out.println("fieldInit1.filedInitValue = " + finalInit1.filedInitValue);
        System.out.println("fieldInit2.filedInitValue = " + finalInit2.filedInitValue);
        System.out.println("fieldInit3.filedInitValue = " + finalInit3.filedInitValue);


        // 상수 (static final)
        System.out.println("FieldInit.CONST_VALUE = " + FinalInit.CONST_VALUE);
    }
}
