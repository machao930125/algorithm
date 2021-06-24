package org.chao;

/**
 * 股票交易问题：
 * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
 * {1, 1, 5, 9, 2, 6, 4, 12}
 */
public class Code005_StockMaxProfit {
    // 只允许进行1次交易
    public static int maxProfit(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min >= arr[i]) {
                min = arr[i];
                continue;
            }
            maxProfit = Math.max(maxProfit, arr[i] - min);
        }
        return maxProfit;
    }

    // 允许进行多次交易
    public static int maxProfit2(int[] arr) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int dp = arr[i] - arr[i - 1];
            if (dp > 0) {
                maxProfit += dp;
            }
        }
        return maxProfit;
    }

    // 进行两次交易
    public static int maxProfit3(int[] prices) {
        int len = prices.length;
        // 获取到第i天只完成一次交易的最大值
        int min_price = prices[0];
        int[] price1 = new int[len];
        for (int i = 1; i < len; i++) {
            min_price = Math.min(min_price, prices[i]);
            price1[i] = Math.max(price1[i - 1], prices[i] - min_price);

        }

        // 获取第i天到最后一天只完成一次交易获取的最大值
        int[] price2 = new int[len];
        int price_max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            price_max = Math.max(price_max, prices[i]);
            price2[i] = Math.max(price_max - prices[i], price2[i + 1]);
        }

        // 第一天到第i天内最大值和第i天到最后一天最大值相加
        int ans = 0;
        for (int i = 0; i < len ; i++) {
            ans = Math.max(ans, price1[i] + price2[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 9, 2, 6, 4, 12};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit2(arr));
        System.out.println(maxProfit3(arr));
    }
}
