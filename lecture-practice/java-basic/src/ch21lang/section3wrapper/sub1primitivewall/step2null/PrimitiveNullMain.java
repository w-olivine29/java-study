package ch21lang.section3wrapper.sub1primitivewall.step2null;

//기본형의 한계2
public class PrimitiveNullMain {
    public static void main(String[] args) {

        // 기본형은 사용하려면 항상 값을 가져야한다
        int[] intArray = {-1, 0, 1, 2, 3, 4};

        System.out.println("findValue(intArray, 0) -> " + findValue(intArray, 0));
        System.out.println("findValue(intArray, 2) -> " + findValue(intArray, 2));

        // 출력결과만 보면 어떤 의미인지 명확하지 않게됨 (찾으려던 값이 -1?, 찾지 못해서 -1?)
        System.out.println("findValue(intArray, -1) -> " + findValue(intArray, -1)); //-1
        System.out.println("findValue(intArray, 10) -> " + findValue(intArray, 10)); //-1
    }


    // 의도) 원하는 숫자가 찾았다면 해당 숫자를 반환, 아니면 -1 반환
    private static int findValue(int[] intArray, int target) {
        for (int value : intArray) {
            if (value == target) {
                return value;
            }
        }

        //int는 null을 반환할 수 없으므로 실패 시 -1을 관례적으로 반환
        //(일반적으로 -1은 실패 또는 부정을 나타냄)
        return -1;
    }
}
