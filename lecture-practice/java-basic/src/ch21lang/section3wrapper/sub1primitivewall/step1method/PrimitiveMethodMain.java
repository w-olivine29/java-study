package ch21lang.section3wrapper.sub1primitivewall.step1method;

// 기본형의 한계1
public class PrimitiveMethodMain {
    public static void main(String[] args) {

        int value = 10;
        int i1 = compareTo(value, 30);
        int i2 = compareTo(value, 3);
        int i3 = compareTo(value, 10);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3= " + i3);

        /*
        현재는 value를 외부 메서드를 통해 비교 중
        value 자체적으로 비교 메서드를 갖는 것이 더 객체지향적이나
        기본형 타입은 객체가 아니기때문에 불가능
        */

    }

    public static int compareTo(int value, int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }
}
