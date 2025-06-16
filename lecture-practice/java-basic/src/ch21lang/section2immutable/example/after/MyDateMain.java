package ch21lang.section2immutable.example.after;

// 공유 참조 사이드 이펙트 해결하기
public class MyDateMain {

    public static void main(String[] args) {
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = date1;
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date1);

        System.out.println("2025 - > date1");
        date2 = date2.withYear(2025);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
    }
}
