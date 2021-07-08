package org.chao.leetcode;

/**
 * 动态规划
 */
public class Code_055_JumpGame {
    // [3,2,1,0,4]
    public static boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res[i-1] == 0){
                return false;
            }
            if (res[i -1] >= nums.length - i ){
                return true;
            }
            res[i] = Math.max(res[i-1] - 1, nums[i]);
        }
        return true;
    }
}
