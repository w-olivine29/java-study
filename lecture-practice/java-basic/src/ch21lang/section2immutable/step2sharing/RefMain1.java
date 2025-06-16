package ch21lang.section2immutable.step2sharing;


public class RefMain1 {
    public static void main(String[] args) {

        Address a = new Address("강북구");
        Address b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        changeAddress(b, "도봉구");
        System.out.println("b -> 도봉구");
        System.out.println("a = " + a); //도봉구 (사이드이펙트 발생)
        System.out.println("b = " + b); //도봉구
    }

    private static void changeAddress(Address address, String addressName) {
        System.out.println("change address -> " + addressName);
        address.setValue("addressName");
    }
}
