package org.chao.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排列组合2
 */
public class Code_047_permuteUnique {
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums){
        used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, data, 0);

        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> data, int index){
        if (nums.length == index){
            ans.add(new ArrayList<>(data));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i> 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            used[i] = true;
            data.add(nums[i]);
            backtrack(nums, ans, data, index + 1);
            used[i] = false;
            data.remove(data.size() - 1);
        }
    }






















}
