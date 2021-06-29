package org.chao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大子序和
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/subsets
 */
public class Code_078_SubSets {
    //    输入：nums = [1,2,3]
    //    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> listTemp = new ArrayList();
            for (int j = 0; j < result.size(); j++) {
                List<Integer> list = new ArrayList();
                list.addAll(result.get(j));
                list.add(nums[i]);
                listTemp.add(list);
            }
            List<Integer> list2 = new ArrayList();
            list2.add(nums[i]);
            result.add(list2);
            result.addAll(listTemp);
        }
        result.add(new ArrayList());
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }
}
