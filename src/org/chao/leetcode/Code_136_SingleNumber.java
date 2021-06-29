package org.chao.leetcode;

/**
 * 只出现一次的数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 */
public class Code_136_SingleNumber {
    public static int singleNumber(int[] nums) {
        for(int i = 1; i< nums.length; i ++){
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,6,6,2,1};
        System.out.println(singleNumber(arr));
    }
}

