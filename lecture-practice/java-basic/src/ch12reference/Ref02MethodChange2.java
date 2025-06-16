package ch12reference;

public class Ref02MethodChange2 {
    public static void main(String[] args) {
        Data data = new Data();
        data.value = 10;

        System.out.println("=== 메서드 호출 전: data.value = " + data.value); //10

        changeReference(data); // data 변수의 값을 복사해서 인수로 넘김 (주소값)

        System.out.println("=== 메서드 호출 후: data.value  = " + data.value); //100

    }

    static void changeReference(Data data) { // 인수로 넘어온 값을 해당 매개변수에 대입
        data.value = 100; // 매개변수로 넘어온 주소값에 접근해서 값을 대입
    }
}
