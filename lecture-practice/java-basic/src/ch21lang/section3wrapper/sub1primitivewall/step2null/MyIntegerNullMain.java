package ch21lang.section3wrapper.sub1primitivewall.step2null;

public class MyIntegerNullMain {
    public static void main(String[] args) {

        //-1, 0, 1, 2, 3, 4
        MyInteger[] intArray = {
                new MyInteger(-1),
                new MyInteger(0),
                new MyInteger(1),
                new MyInteger(2),
                new MyInteger(3),
                new MyInteger(4)};

        System.out.println("findValue(intArray, 0) -> " + findValue(intArray, 0)); //0
        System.out.println("findValue(intArray, 2) -> " + findValue(intArray, 2)); //2

        // 데이터가 없다면 null 이라는 명확한 값을 반환
        System.out.println("findValue(intArray, -1) -> " + findValue(intArray, -1)); //-1
        System.out.println("findValue(intArray, 10) -> " + findValue(intArray, 10)); //null
    }


    // 의도) 원하는 숫자가 찾았다면 해당 숫자값을 가진 객체를 반환, 아니면 null 반환
    private static MyInteger findValue(MyInteger[] intArray, int target) {
        for (MyInteger value : intArray) {
            if (value.compareTo(target) == 0) {
                return value;
            }
        }

        // 반환값이 객체이기때문에 null값 사용가능
        return null;
    }
}
