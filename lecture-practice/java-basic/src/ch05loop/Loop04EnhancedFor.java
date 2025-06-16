package ch05loop;

// ch09 array 부분 선행필요
public class Loop04EnhancedFor {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        // === 일반 for문 ================  인덱스 값이 필요할 경우에는 일반 for문
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + "번 인덱스의 값은 " + nums[i]);
        }
        System.out.println();

        // === for each문 (향상된 for문) ================
        for (int num : nums) {
            System.out.println(num);
        }


    }
}
