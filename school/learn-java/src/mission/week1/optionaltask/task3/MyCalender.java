package mission.week1.optionaltask.task3;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class MyCalender {

    // 필요한 값: 해당월의 시작요일 , 해당 월의 총 일수
    private int totalDays;
    private DayOfWeek startDay;
    private LocalDate localDate;


    public MyCalender(int year, int month) {
        this.localDate = LocalDate.of(year, month, 1);

        //this.totalDays = localDate.plusMonths(1).getDayOfYear() - localDate.getDayOfYear(); // 해당 방식은 12월에서 문제발생
        this.totalDays = localDate.lengthOfMonth();
        this.startDay = localDate.getDayOfWeek();

    }


    // 캘린더 자체 공통 메서드
    public static String getWeekHeaders() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", "일", "월", "화", "수", "목", "금", "토");
    }

    public String getTitle() {
        return String.format("[%d년 %02d월]", localDate.getYear(), localDate.getMonth().getValue());
    }


    // n번째 주
    public String getWeekDays(int weekOfMonth) {

        if (weekOfMonth == 1) {
            return getFirstWeek();
        }

        StringBuilder sb = new StringBuilder();

        int sunday;
        int saturday;

        // 원하는 주의 토요일(끝) & 일요일(시작)
        if (startDay.equals(DayOfWeek.SUNDAY)) {
            sunday = 1 + (7 * (weekOfMonth - 1));
            saturday = sunday + 6;
        } else {
            saturday = 1 + (6 - startDay.getValue()) + (7 * (weekOfMonth - 1));
            sunday = saturday - 6;
        }

        for (int i = sunday; i <= saturday; i++) {
            if (i > totalDays) {
                sb.append("\t");
            } else {
                sb.append(String.format("%02d\t", i));
            }
        }
        return sb.toString();
    }


    private String getFirstWeek() {

        StringBuilder sb = new StringBuilder();

        // (startDay.getValue() % 7) 횟수만큼 공백 출력
        int day = 0;
        for (int i = 1; i <= 7; i++) {
            if (i <= startDay.getValue() % 7) {
                sb.append(String.format("%2s\t", ""));
            } else {
                sb.append(String.format("%02d\t", ++day));
            }
        }

        return sb.toString();
    }
}
