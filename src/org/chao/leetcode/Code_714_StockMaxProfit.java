package org.chao.leetcode;
/**
 * 买卖股票的最佳时机 IV（费用）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class Code_714_StockMaxProfit {
    // fee
    public static int maxProfit(int[] prices, int fee){
        int dp0 = 0 ; // 未持有
        int dp1 = - prices[0]; // 持有

        for (int i = 0; i < prices.length; i++) {
            int dp0Next = Math.max(dp0, dp1 + prices[i] - fee);
            int dp1Next = Math.max(dp1, dp0 - prices[i]);
            dp0 = dp0Next;
            dp1 = dp1Next;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr, 2));
    }
}
