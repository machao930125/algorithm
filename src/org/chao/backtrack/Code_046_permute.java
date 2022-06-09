package org.chao.backtrack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class Code_046_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> data = new LinkedList<>();
        for (Integer num : nums) {
            data.add(num);
        }

        backtrack(data, ans, nums.length, 0);
        return ans;
    }

    public void backtrack(List<Integer> data, List<List<Integer>> ans, int length, int index) {
        if (index == length) {
            ans.add(new LinkedList<>(data));
            return;
        }
        for (int i = index; i < length; i++) {
            Collections.swap(data, index, i);
            backtrack(data, ans, length, index + 1);
            Collections.swap(data, index, i);
        }
    }

}
