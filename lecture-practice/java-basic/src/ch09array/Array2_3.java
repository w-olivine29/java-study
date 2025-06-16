package ch09array;

public class Array2_3 {
    public static void main(String[] args) {

        // === 정방형 2차원 배열 =================================================
        int[][] arr1 = new int[][]{
                {1, 2, 3},
                {1, 2, 3}
        };

        // === 비정방형 2차원 배열 =================================================
        int[][] arr2 = new int[][]{
                {1, 2},
                {1, 2, 3}
        };

        int[][] arr3 = new int[2][];

        arr2[0] = new int[]{1, 2};
        arr2[1] = new int[]{1, 2, 3};


        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[row].length; col++) {
                System.out.print(arr1[row][col] + " ");
            }
        }
        System.out.println();
    }


}

