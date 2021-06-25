package org.chao.leetcode;


/**
 * 买卖股票的最佳时机 IV (冻结)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Code_309_StockMaxProfit {
    public static int maxProfit(int[] prices){
        int length = prices.length;
        // dp0 未持有，未冻结
        int dp0 = 0;
        // dp1 未持有，冻结
        int dp1 = 0;
        // dp2 持有
        int dp2 = -prices[0];

        for(int i = 1 ; i < length ; i ++){
            int dp0Next = Math.max(dp0, dp1);
            int dp1Next = dp2 + prices[i];
            int dp2Next = Math.max(dp2, dp0 - prices[i]);

            dp0 = dp0Next;
            dp1 = dp1Next;
            dp2 = dp2Next;
        }
        return Math.max(dp0, dp1);
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
