package mission.week1.optionaltask.task3;

public class CalenderPrinter {

    public static void printWeekHeader(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(MyCalender.getWeekHeaders() + "\t\t\t");
        }
    }


    public static void printMonthsTitle(MyCalender[] calenders) {
        for (MyCalender calender : calenders) {
            System.out.print(calender.getTitle() + "\t\t\t\t\t\t");
        }
    }

    public static void printMonthsWeek(int weekNumber, MyCalender[] calenders) {

        for (MyCalender calender : calenders) {
            System.out.print(calender.getWeekDays(weekNumber) + "\t\t");
        }

        System.out.println();
    }
}
