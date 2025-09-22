package mission.week1;

// 41기 - 유도경
public class JavaTask1_3 {
    public static void main(String[] args) {

        System.out.println("==== upcasting ====");
        int intValue1 = 10;
        double doubleValue1 = intValue1;

        System.out.println("intValue = " + intValue1);
        System.out.println("doubleValue = " + doubleValue1);


        System.out.println("==== downCasting ====");

        double doubleValue2 = 93.7;
        int intValue2 = (int) doubleValue2;

        System.out.println("doubleValue2 = " + doubleValue2);
        System.out.println("intValue2 = " + intValue2);
    }
}
