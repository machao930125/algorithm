package org.chao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续序列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 */
public class Code_128_LongestSequence {
    // dp cur = 1+ left + right；
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        for (int num : nums) {
            if (map.get(num) != null) {
                continue;
            }
            int left = map.getOrDefault(num - 1,0);
            int right = map.getOrDefault(num + 1, 0);

            int cur = 1 + left + right;
            if (cur > length) {
                length = cur;
            }
            map.put(num, cur);
            map.put(num - left, cur);
            map.put(num + right, cur);
        }

        return length;
    }

    public static int longestConsecutive2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }

        int length = 0;
        // 找出每一段最小值开始计算
        for (int num : nums) {
            if (!set.contains(num -1)){
                int curLength = 1;
                while (set.contains(num + 1)){
                    curLength ++;
                    num++;
                }
                length = Math.max(length, curLength);
            }
        }

        return length;
    }

    public static void main(String[] args) {
//        int[] arr = {100, 3, 4, 3, 2, 3, 4, 4, 4, 200, 1, 3, 2};
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
        System.out.println(longestConsecutive2(arr));
    }
}
