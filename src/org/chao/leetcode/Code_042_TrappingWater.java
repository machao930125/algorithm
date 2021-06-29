package org.chao.leetcode;

/**
 * 盛水最多
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/trapping-rain-water
 */
public class Code_042_TrappingWater {
    // height = [0,1,0,2,1,0,1,3,2,1,2,1]
    public static int trap(int[] height) {
        // 定义双指针
        int left = 0;
        int right = height.length - 1;

        // 定义游标
        int cur;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                cur = left + 1;
                while (height[left] >= height[cur] && cur < right) {
                    result += height[left] - height[cur];
                    cur++;
                }
                left = cur;
            } else {
                cur = right - 1;
                while (height[right] >= height[cur] && cur > left) {
                    result += height[right] - height[cur];
                    cur--;
                }
                right = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 3};
        System.out.println(trap(height));
    }
}
