package arrays;

import java.util.Arrays;

public class Pairs {

    public static void main(String[] args) {
        int[] nums = {2, 7, 13, 15};
        int[] result = twoSUm(nums, 20);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSUm(int[] nums, int target) {
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("Not found");
    }
}
