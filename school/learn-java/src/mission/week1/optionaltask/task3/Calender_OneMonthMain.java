package mission.week1.optionaltask.task3;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/* 선택과제 3번. 달력 출력 프로그램
입력받은 년도와 월을 통한 달력 생성
입력값은 년도, 월을 입력
날짜는 LocalDate 클래스를 이용(Calendar와 Date 클래스도 이용 가능)
출력은 입력한 달을 기준으로 이전달, 입력달, 현재달 출력(3달 출력)
*/
public class Calender_OneMonthMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        int month;

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        year = Integer.parseInt(scanner.nextLine());

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        month = Integer.parseInt(scanner.nextLine());


        System.out.println(getCalender(year, month));
    }


    // 필요한 값: 해당월의 시작요일 , 해당 월의 총 일수
    private static String getCalender(int year, int month) {
        LocalDate targetDate = LocalDate.of(year, month, 1);

        // 해당 날짜의 요일 (xxxx년, xx월 01일의 요일)
        DayOfWeek startDay = targetDate.getDayOfWeek(); // enum DayOfWeek [월(1), 화(2) ... 일(7)]

        // 해당 월의 총 일수 (다음 월의 1일 연중일자 - 타켓 월의 1일 연중일자)
        int totalDays = targetDate.plusMonths(1).getDayOfYear() - targetDate.getDayOfYear();


        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[%d년 %02d월]\n", year, month));
        sb.append(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "일", "월", "화", "수", "목", "금", "토"));


        int day = 0;
        for (int i = 1; i <= totalDays + (startDay.getValue() % 7); i++) { // 7일마다 개행하기 위해서 1부터 시작

            // (startDay.getValue() % 7) 횟수만큼 공백 출력
            if (i <= startDay.getValue() % 7) {
                sb.append(String.format("%2s\t", ""));
            } else {
                sb.append(String.format("%02d\t", ++day));

                // 토요일마다 개행해서 다음주로 넘어가기
                if (i % 7 == 0) {
                    sb.append("\n");
                }
            }


        }

        return sb.toString();
    }
}
