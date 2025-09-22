package mission.week1.optionaltask.task3;


import java.util.Scanner;

/* 선택과제 3번. 달력 출력 프로그램
입력받은 년도와 월을 통한 달력 생성
입력값은 년도, 월을 입력
날짜는 LocalDate 클래스를 이용(Calendar와 Date 클래스도 이용 가능)
출력은 입력한 달을 기준으로 이전달, 입력달, 현재달 출력(3달 출력)
*/
public class CalenderPrinterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCalender[] calenders = new MyCalender[3];

        System.out.println("[달력 출력 프로그램]");


        while (true) {
            try {

                System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
                int year = Integer.parseInt(scanner.nextLine());

                System.out.print("달력의 월을 입력해 주세요.(mm): ");
                int month = Integer.parseInt(scanner.nextLine());

                calenders[1] = new MyCalender(year, month);

                if (month == 1) {
                    calenders[0] = new MyCalender(year - 1, 12);
                } else {
                    calenders[0] = new MyCalender(year, month - 1);
                }


                if (month == 12) {
                    calenders[2] = new MyCalender(year + 1, 1);
                } else {
                    calenders[2] = new MyCalender(year, month + 1);
                }
                break;

            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
            }
        }


        // 제목
        CalenderPrinter.printMonthsTitle(calenders);
        System.out.println();

        // 요일
        CalenderPrinter.printWeekHeader(calenders.length);
        System.out.println();

        // 주
        for (int i = 1; i <= 6; i++) {
            CalenderPrinter.printMonthsWeek(i, calenders);
        }
    }

}
