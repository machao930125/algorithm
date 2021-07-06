package org.chao.leetcode;

/**
 * 动态规划
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/maximum-subarray
 */
public class Code_053_MaxinumSubArray {

    public static int maxSubArray(int[] nums) {
        // 边界
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 定义状态
        int[] max = new int[nums.length];
        // 初始值
        max[0] = nums[0];
        int result = max[0];

        // 状态转移 cur = max[i - 1] + nums[i] or nums[i];
        for (int i = 1; i < nums.length; i++) {
            if (max[i - 1] > 0) {
                max[i] = max[i - 1] + nums[i];
            } else {
                max[i] = nums[i];
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
