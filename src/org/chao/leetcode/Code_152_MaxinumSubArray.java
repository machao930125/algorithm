package org.chao.leetcode;

public class Code_152_MaxinumSubArray {
    public static int maxSubArray(int[] nums) {
        // 边界
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        // 定义状态
        int[][] res = new int[nums.length][2];
        res[0][0] = nums[0];
        res[0][1] = nums[0];
        int rtn= Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0){
                res[i][0] = Math.min(res[i-1][0] * nums[i], nums[i]);
                res[i][1] = Math.max(res[i-1][1] * nums[i], nums[i]);
            }else {
                res[i][1] = Math.max(res[i-1][0] * nums[i], nums[i]);
                res[i][0] = Math.min(res[i-1][1] * nums[i], nums[i]);
            }
            rtn = Math.max(rtn, res[i][1]);
        }
        return rtn;

    }

    public static void main(String[] args) {
        int[] arr = {-2,0,-4};
        System.out.println(maxSubArray(arr));
    }
}
