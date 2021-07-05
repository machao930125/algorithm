package org.chao.leetcode;

/**
 * 动态规划
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/n-th-tribonacci-number
 */
public class Code_1137_Fib2Number {
    //T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
    public static int fib(int n){
        if (n == 0){return 0;}
        if (n == 1){return 1;}
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i-3] + res[i-2] + res[i-1];
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(25));
    }
}
