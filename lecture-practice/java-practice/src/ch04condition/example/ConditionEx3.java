package ch04condition.example;

/**
 * 학점에 따른 안내문구 출력
 * "A": "[축하드립니다] A학점입니다.";
 * "B": "B학점입니다.";
 * "C": "C학점입니다.";
 * "D": "D학점입니다.";
 * "F": "[재수강필수] F학점입니다.";
 */
public class ConditionEx3 {
    public static void main(String[] args) {
        String grade = "A";

        String result = switch (grade) {
            case "A" -> {
                System.out.print("[축하드립니다] ");
                yield grade + "학점입니다.";
            }
            case "B", "C", "D" -> grade + "학점입니다.";
            case "F" -> {
                System.out.print("[재수강필수] ");
                yield grade + "학점입니다.";
            }
            default -> "전산오류";
        };
        System.out.println(result);
    }
}
