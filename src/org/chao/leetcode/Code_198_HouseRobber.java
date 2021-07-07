package org.chao.leetcode;

/**
 * 动态规划
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/hose-robber/
 */
public class Code_198_HouseRobber {
    public static int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = nums[0] > nums[1] ? nums[0]:nums[1];
        for(int i = 2 ; i< nums.length; i++){
            res[i] = Math.max(res[i-2] + nums[i] ,res[i-1]);
        }
        return res[nums.length -1];
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,14};
        System.out.println(rob(arr));
    }
}
