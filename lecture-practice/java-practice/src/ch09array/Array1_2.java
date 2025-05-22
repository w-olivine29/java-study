package ch09array;

public class Array1_2 {
    public static void main(String[] args) {

        //=== [선언 & 생성] 후 초기화 ===============================
        int[] array1 = new int[5];
        for (int i = 1; i <= array1.length; i++) {
            array1[i - 1] = i * 10;
        }

        //=== 동시에 [생성 & 초기화] ===============================
        int[] array2;
        array2 = new int[]{10, 20, 30, 40, 50};

        int[] array3 = new int[]{10, 20, 30, 40, 50};
        // 직접 값을 넣어서 초기화할때는 길이를 넣지 못한다.
        //int[] array3 = new int[5]{10, 20, 30, 40, 50};

        //=== 가장 단순한 형태 ===============================
        int[] array4 = {10, 20, 30, 40, 50};

        //but 선언과 분리불가
//        int[] array4;
//        array4 = {10, 20, 30, 40, 50};

    }
}
