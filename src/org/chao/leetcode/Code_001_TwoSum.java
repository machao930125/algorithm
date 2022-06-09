package org.chao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出两数之和为一个数的索引
 */
public class Code_001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(target - nums[i]);
            if (result != null){
                return new int[]{result, i};
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

}
