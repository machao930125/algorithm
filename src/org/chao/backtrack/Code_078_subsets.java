package org.chao.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class Code_078_subsets {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        backtrack(0, nums);
        return ans;
    }
    public void backtrack(int cur, int[] nums){
        if (cur == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[cur]);
        backtrack(cur + 1, nums);
        temp.remove(temp.size() - 1);
        backtrack(cur + 1, nums);
    }
}
