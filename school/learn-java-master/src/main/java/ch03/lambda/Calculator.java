package ch03.lambda;

public class Calculator {

    private final double a;
    private final double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(Operate operate) {
        return operate.operate(a, b);
    }
}
