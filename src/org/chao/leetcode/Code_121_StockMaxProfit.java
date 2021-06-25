package org.chao.leetcode;

/**
 * 买卖股票的最佳时机
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class Code_121_StockMaxProfit {

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1 ; i < prices.length; i ++){
            if (prices[i] < min){
                min = prices[i];
                continue;
            }
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
