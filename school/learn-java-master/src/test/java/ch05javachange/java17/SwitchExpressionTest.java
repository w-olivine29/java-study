package ch05javachange.java17;

import org.junit.jupiter.api.Test;


// 실제 정식기능 확정 버전은 14
class SwitchExpressionTest {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @Test
    void switchExpression() {
        Day targetDay = Day.MONDAY;

        // old
        String type1;

        switch (targetDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                type1 = "WORKDAY";
                break;
            case SATURDAY:
            case SUNDAY:
                type1 = "HOLIDAY";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + targetDay);
        }

        System.out.println(type1);

        // new
        String type2 = switch (targetDay) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "WORKDAY";
            case SATURDAY, SUNDAY -> "HOLIDAY";
        };

        System.out.println(type2);
    }

    @Test
    void switchExpression2() {
        Day targetDay = Day.MONDAY;

        // old
        String type1;

        switch (targetDay) {
            case MONDAY:
                type1 = "월요일";
                break;
            case TUESDAY:
                type1 = "화요일";
                break;
            case WEDNESDAY:
                type1 = "수요일";
                break;
            case THURSDAY:
                type1 = "목요일";
                break;
            case FRIDAY:
                type1 = "금요일";
                break;
            case SATURDAY:
                type1 = "토요일";
                break;
            case SUNDAY:
                type1 = "일요일";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + targetDay);
        }

        System.out.println(type1);

        // new
        String type2 = switch (targetDay) {
            case MONDAY -> "월요일";
            case TUESDAY -> "화요일";
            case WEDNESDAY -> "수요일";
            case THURSDAY -> "목요일";
            case FRIDAY -> "금요일";
            case SATURDAY -> "토요일";
            case SUNDAY -> "일요일";
        };

        System.out.println(type2);
    }
}