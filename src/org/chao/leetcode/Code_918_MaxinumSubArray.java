package org.chao.leetcode;

/**
 * 动态规划，环形数组
 */
public class Code_918_MaxinumSubArray {

    public static int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = 1;
        int max = nums[0];
        int preMax = nums[0];
        while (right != left) {
            if (preMax < 0){
                left = right;
//                max = max ,nums[right];
            }

            max = Math.max(max, preMax + nums[right]);
            right = ++ right % nums.length;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println("ugc".equals(null));
    }
}
