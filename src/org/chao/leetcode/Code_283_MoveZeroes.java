package org.chao.leetcode;

import java.util.Arrays;

/**
 * 移动零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes/
 */
public class Code_283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        // 记录最左侧为0的位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index, i);
                index++;
            }
        }
    }


    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,0,0,0,0,1,0,3,12,0,13};
        moveZeroes(arr);
        System.out.println(Arrays.asList(arr));
    }

}
