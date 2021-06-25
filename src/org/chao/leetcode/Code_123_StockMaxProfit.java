package org.chao.leetcode;

/**
 * 买卖股票的最佳时机 III
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Code_123_StockMaxProfit {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        // deal prices1
        int[] prices1 = new int[length];
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            prices1[i] = Math.max(prices1[i - 1], prices[i] - min);
        }

        // deal prices2
        int[] prices2 = new int[length];
        int max = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            prices2[i] = Math.max(prices2[i + 1], max - prices[i]);
        }

        // result
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, (prices1[i] + prices2[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
