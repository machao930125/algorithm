package org.chao.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Code_046_permute_2 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> data = new ArrayList<>();
    public boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int index){
        if (index == nums.length){
            ans.add(new ArrayList(data));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(used[i]){
                continue;
            }
            data.add(nums[i]);
            used[i] =true;
            backtrack(nums, index + 1);
            data.remove(data.size() - 1);
            used[i] = false;
        }
    }




















}
