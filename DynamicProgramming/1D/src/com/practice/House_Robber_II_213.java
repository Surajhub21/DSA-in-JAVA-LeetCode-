package com.practice;

public class House_Robber_II_213 {

    private static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]
        //[2 , 6 , 3 , 1, 14 , 10]
        for (int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2 , 6 , 3 , 1 , 14, 10};
        System.out.println(robLinear(nums, 0, nums.length - 1));
    }
}
