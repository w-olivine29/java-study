package ch22enum.before.step3;


public class ClassGrade {

    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    // 별도로 인스턴스 생성이 가능하면, 위 등급만 있어야한다는 설계가 깨져버린다
    // 생성자를 private 으로 만들어서, ClassGrade 인스턴스는 내부에 있는 상수 인스턴스만 사용할 수 있도록 한다
    private ClassGrade() {
    }

    /* 타입 안전 열거형 패턴
     * - 타입 안정성 향상 (정해진 객체만 사용가능)
     * - 데이터 일관성 (정해진 객체만 사용하므로 데이터 일관성 보장)
     * */
}
