package org.chao.leetcode;

/**
 * 盛水最多
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/container-with-most-water
 */
public class Code_011_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        // 定义左右指针（双指针）
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max((right - left) * height[left], maxArea);
                left++;
            } else {
                maxArea = Math.max((right - left) * height[right], maxArea);
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }


}
