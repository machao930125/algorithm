package org.chao.leetcode;

/**
 * 买卖股票的最佳时机 II
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class Code_122_StockMaxProfit {

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int dp = prices[i] - prices[i - 1];
            if (dp > 0) {
                max += dp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

}
