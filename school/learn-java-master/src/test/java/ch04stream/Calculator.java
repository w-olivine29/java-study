package ch04stream;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum Calculator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final DoubleBinaryOperator operator;

    Calculator(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static double calculate(String query) {
        String operator = query.replaceAll("[0-9.]", "");
        String[] numbers = query.split("[+\\-*/]");

        double number1 = Double.parseDouble(numbers[0]);
        double number2 = Double.parseDouble(numbers[1]);

        Calculator calc = Arrays.stream(values())
                .filter(calculator -> calculator.getSymbol().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operator: " + operator));

        return calc.getOperator().applyAsDouble(number1, number2);
    }

    public String getSymbol() {
        return symbol;
    }

    public DoubleBinaryOperator getOperator() {
        return operator;
    }
}
