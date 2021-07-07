package org.chao.leetcode;

import java.util.Arrays;

/**
 * 双指针
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Code_189_RotateArray {
    //输入: nums = [1,2,3,4,5,6,7], k = 3
    //输出: [5,6,7,1,2,3,4]
    public static void rotate(int[] nums, int k) {
        int count = nums.length;
        int start = 0;
        int changeIndex = 0;
        int temp = nums[start];
        while(count-- > 0){
            int lastId = getLastIndex(nums, changeIndex, k);
            if(lastId == start){
                nums[changeIndex] = temp;
                start ++;
                changeIndex = start;
                temp = nums[start];
            }else {
                nums[changeIndex] = nums[lastId];
                changeIndex = lastId;
            }

        }
    }

    public static int getLastIndex(int[] nums, int index, int k){
        return (nums.length -k + index)% nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
