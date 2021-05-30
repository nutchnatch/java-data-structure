package arrays;

public class MissingNUmber {

    public static void main(String[] args) {

        int nums[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int N = nums.length;
        int maxSum = N * (N + 1) / 2;
        int maxSunInArray = 0;
        for(int i = 0; i < N; i ++) {
            maxSunInArray += nums[i];
        }
        return maxSum - maxSunInArray;
    }
}
