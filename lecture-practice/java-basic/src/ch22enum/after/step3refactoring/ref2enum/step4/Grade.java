package ch22enum.after.step3refactoring.ref2enum.step4;

/*
객체지향 관점에서
자신의 데이터를 외부에 노출하지않고,
Grade 클래스가 자신의 할인율을 스스로 관리하는 것이 캡슐화 원칙에 더 맞음
*/
public enum Grade {

    // public static final Grade 상수이름 = new Grade();
    BASIC(10),
    GOLD(20),
    DIAMOND(30);

    private final int discountPercent;

    Grade(int discountPercent) { //private 생략가능
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
