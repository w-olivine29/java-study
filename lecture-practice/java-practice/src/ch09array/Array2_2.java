package ch09array;

public class Array2_2 {
    public static void main(String[] args) {

        // 2 * 3  2차원 배열
        int[][] arr = new int[2][3]; //행2, 열3


        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = col + 1;
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }


    }
}
