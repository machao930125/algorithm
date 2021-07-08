package org.chao.leetcode;

/**
 * 动态规划
 */
public class Code_045_JumpGame {
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(arr));
    }
}
