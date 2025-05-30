package ch21lang.section2immutable.step3immutable.ex1;


public class AddressMain {
    public static void main(String[] args) {

        ImmutableAddress a = new ImmutableAddress("강북구");
        ImmutableAddress b = a; //참조값 대입 자체는 방지불가
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // 불변이라는 제약으로 사이드이펙트 방지
        b = b.changeAddress("도봉구");
        System.out.println("b -> 도봉구");
        System.out.println("a = " + a); //강북구
        System.out.println("b = " + b); //도봉구
    }
}
