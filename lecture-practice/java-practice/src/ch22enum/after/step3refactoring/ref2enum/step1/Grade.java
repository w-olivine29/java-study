package ch22enum.after.step3refactoring.ref2enum.step1;

// 열거형클래스는 java.lang.Enum 를 상속
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
}
