package org.chao.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class Code_039_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> combine = new LinkedList<>();
        backtrack(candidates, ans, combine, target, 0);
        return ans;
    }


    public void backtrack(int[] candidates, List<List<Integer>> ans, List<Integer> combine, int target, int index){
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            ans.add(new LinkedList<>(combine));
            return;
        }

        backtrack(candidates, ans, combine, target, index + 1);
        if (target - candidates[index] >= 0){
            combine.add(candidates[index]);
            backtrack(candidates, ans, combine, target - candidates[index], index);
            combine.remove(combine.size() - 1);
        }
    }


















}
