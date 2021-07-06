package org.chao.leetcode;


public class Code_746_ClimbStairs {
    // [10,15,20,30,30,30] 60
    public static int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length];
        res[0] = 0;
        res[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            res[i] =Math.min(res[i-1] + cost[i], res[i-2] + cost[i-1]) ;
        }
        return res[cost.length -1];
    }

    public static void main(String[] args) {
        int[] arr = {10,15,20,30,30,30};
        System.out.println(minCostClimbingStairs(arr));
    }
}
