package org.chao.array;

/**
 * 股票交易，不限制次数
 */
public class Code_dp_122_maxProfit {
    public int maxProfit(int[] prices){
        if (prices.length < 2){
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] , dp[i- 1] + prices[i] - prices[i-1]);
        }
        return dp[prices.length -1];

    }

}
