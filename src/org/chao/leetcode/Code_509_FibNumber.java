package org.chao.leetcode;

/**
 * 动态规划
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Code_509_FibNumber {
    //F(0) = 0，F(1) = 1
    //F(n) = F(n - 1) + F(n - 2)，其中 n > 1

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] res = new int[n + 1];
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }



    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
