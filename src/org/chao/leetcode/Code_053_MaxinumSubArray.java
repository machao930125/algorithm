package org.chao.leetcode;

/**
 * 动态规划
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/maximum-subarray
 */
public class Code_053_MaxinumSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int ans = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            ans = Math.max(ans, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));
    }
}
