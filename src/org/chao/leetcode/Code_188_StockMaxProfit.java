package org.chao.leetcode;

/**
 * 买卖股票的最佳时机 IV（交易k次）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Code_188_StockMaxProfit {
    public static int maxProfit(int[] prices, int k) {
        int length = prices.length;
        // deal k
        k = Math.min(k, length / 2);

        // deal dp
        int[] dp = new int[2 * k + 1];
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[i] = -prices[0];
        }

        // dp
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if ((j & 1) == 1) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[2 * k];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println(maxProfit(arr, 4));
    }

}
