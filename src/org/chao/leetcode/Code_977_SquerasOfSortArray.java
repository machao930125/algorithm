package org.chao.leetcode;

import java.util.Random;

/**
 *  双指针
 */
public class Code_977_SquerasOfSortArray {
    // 输入：nums = [-7,-3,2,3,11]
    //输出：[4,9,9,49,121]
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for (int i = nums.length- 1; i >= 0; i--) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])){
                res[i] = nums[right] * nums[right];
                right --;
            }else {
                res[i] = nums[left] * nums[left];
                left ++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] arr = {-12,-7,-3,2,3,11};
//        System.out.println(Arrays.toString(sortedSquares(arr)));
        for (int i = 0; i < 10000; i++) {
            System.out.println(gen());
        }

    }
    public static String gen(){
        StringBuilder builder = new StringBuilder();
        builder.append( System.currentTimeMillis());
        Random random = new Random();
        for (int j = 0; j < 4; j++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }
}
