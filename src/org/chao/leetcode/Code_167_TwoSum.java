package org.chao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 双指针
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Code_167_TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (null != map.get(target - numbers[i])) {
                int other = map.get(target - numbers[i]);
                return i > other ? new int[]{other + 1, i + 1} : new int[]{i + 1, other + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 13};
        System.out.println(Arrays.toString(twoSum(arr, 14)));
    }
}
