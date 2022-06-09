package org.chao.array;

/**
 * 长度最小的子数组
 */
public class Code_209_minSubArrayLen {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10, 5,4};
        System.out.println(minSubArrayLen(16, arr));
    }
    public static int minSubArrayLen(int s, int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;

        int ans = Integer.MAX_VALUE;
        int start = 0; int end = 0;
        int sum = 0;
        while (end < n){
            sum += nums[end];
            while (sum >= s){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start ++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0:ans;
    }



























}
