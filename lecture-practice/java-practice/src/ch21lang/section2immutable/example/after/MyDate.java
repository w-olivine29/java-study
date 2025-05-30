package ch21lang.section2immutable.example.after;

public class MyDate {

    private final int year;
    private final int month;
    private final int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public MyDate withYear(int changeYear) {
        return new MyDate(changeYear, month, day);
    }

    public MyDate withMonth(int changeMonth) {
        return new MyDate(year, changeMonth, day);
    }

    public MyDate withDay(int changeDay) {
        return new MyDate(year, month, changeDay);
    }


    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
