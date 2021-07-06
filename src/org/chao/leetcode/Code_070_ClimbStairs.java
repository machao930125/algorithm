package org.chao.leetcode;

/**
 * 动态规划
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Code_070_ClimbStairs {
    // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？fn= fn-1 + fn-2;


    public static int climb(int n) {
        if (n < 3) {
            return n == 1 ? 1 : 2;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];

    }

    public static void main(String[] args) {
        System.out.println(climb(10));
    }
}
