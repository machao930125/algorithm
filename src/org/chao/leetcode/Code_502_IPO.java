package org.chao.leetcode;

import java.util.PriorityQueue;

/**
 * IPO
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ipo
 */
public class Code_502_IPO {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // to speed up: if all projects are available
        if (k <= 0) {
            return w;
        }
        if (k > profits.length) {
            k = profits.length;
        }
        boolean speedUp = true;
        for (int c : capital) {
            if (w < c) {
                speedUp = false;
            }
        }
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : profits) {
                heap.add(p);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            for (int h : heap) {
                w += h;
            }
            return w;
        }

        // 穷举所有情况（贪心）
        for (; k > 0; k--) {
            int max = 0;
            int dp = -1;
            for (int i = 0; i < capital.length; i++) {
                if (w >= capital[i] && profits[i] > max) {
                    max = profits[i];
                    dp = i;
                }
            }
            // 证明后边无解
            if (dp == -1) break;
            w += max;
            profits[dp] = 0;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(findMaximizedCapital(2, 0, profits, capital));
    }
}
