package ch18final.section03reference;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();
        //data = new Data(); //참조대상 변경 불가

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println("data.value = " + data.value);

        data.value = 20;
        System.out.println("data.value = " + data.value);

        // 참조형 변수에 final 붙을 땐, 참조 대상을 다른 대상으로 변경하지 못함 (참조하는 대상의 데이터는 변경 가능)

        // "변수에 들어있는 값 자체를 못 바꾸는 것"
        // 주소값을 못바꾸는 것이지, 해당 주소를 가진 객체의 값을 못 바꾸는 것이 아님
    }
}
