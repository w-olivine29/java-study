package ch03.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator(10, 20);

        // 익명클래스 적용
        assertEquals(30, calculator.calculate(
                new Operate() {
                    @Override
                    public double operate(double a, double b) {
                        return a + b;
                    }
                }));

        // 람다 적용
        assertEquals(30, calculator.calculate((a, b) -> a + b)); //Double::sum (해당 메서드 참조로 대체 가능)
    }

    @Test
    void testAdd2() {
        Calculator calculator = new Calculator(10, 20);

        // 람다 적용
        assertEquals(30, calculator.calculate(getSumOperate()));
    }

    // 재사용성을 높이기 위해 람다를 반환하는 메서드 정의
    private Operate getSumOperate() {
        return Double::sum;
    }
}