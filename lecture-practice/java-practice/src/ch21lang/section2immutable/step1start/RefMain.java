package ch21lang.section2immutable.step1start;

public class RefMain {
    public static void main(String[] args) {
        //참조형 변수는 하나의 인스턴스 공유가능
        Address a = new Address("강북구");
        Address b = a; // a의 값을 복사 -> b에 대입 (동일한 참조값)
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        b.setValue("도봉구"); //의도: b의 value만 변경
        System.out.println("b -> 도봉구");
        System.out.println("a = " + a); //사이드 이펙트 발생
        System.out.println("b = " + b);
    }
}
