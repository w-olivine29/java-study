package ch21lang.section2immutable.step2sharing;


public class RefMain2 {
    public static void main(String[] args) {

        // 같은 형태의 필드값을 가지지만 별도의 객체로 생성하여 대입 (서로 다른 주소값을 참조)
        Address a = new Address("강북구");
        Address b = new Address("강북구");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b.setValue("도봉구"); //의도: b의 value만 변경
        System.out.println("b -> 도봉구");
        System.out.println("a = " + a); //강북구
        System.out.println("b = " + b); //도봉구

        // 별도의 객체를 생성하여, 한 인스턴스의 값을 변경해도, 다른 인스턴스에게는 영향을 주지 않게됨
        // but 참조값의 공유를 막을 수 있는 방법이 없음 -> 사이드이펙트 발생 가능성
        a = b;
    }
}
