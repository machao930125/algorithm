package org.chao.array;

/**
 * 接雨水
 */
public class Code_042_trap {
    public int trap(int[] height) {
        int left = 0; int right = height.length - 1;
        int cur = 0;
        int ans = 0;
        while (left < right){
            if (height[left] < height[right]){
                cur = left + 1;
                while (height[left] > height[cur] && cur < right){
                    ans += height[left] - height[cur];
                    cur ++;
                }
                left = cur;
            }else {
                cur = right - 1;
                while (height[right] > height[cur] && cur > left){
                    ans += height[right] - height[cur];
                    cur --;
                }
                right = cur;
            }
        }

        return ans;
    }















}
