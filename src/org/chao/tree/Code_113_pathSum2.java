package org.chao.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和2
 */
public class Code_113_pathSum2 {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        dfs(root, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        targetSum -= root.val;
        deque.offerLast(root.val);
        if (root.left == null && root.right == null && targetSum == 0){
            ans.add(new LinkedList<>(deque));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        deque.pollLast();

    }
}
